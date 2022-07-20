package at.little.lucky.controller;

import at.little.lucky.pojo.Message;
import at.little.lucky.pojo.Timeline;
import at.little.lucky.service.MessageService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 15:58
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    public RedisTemplate redisTemplate;


    @PostMapping("/add")
    public Object add(@Valid @RequestBody Message message, BindingResult result, HttpServletRequest httpServletRequest) {
        message.setMessageTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
//            留言校验
        //得到所有错误信息计数
        int errorCount = result.getErrorCount();
        //错误数大于0
        if (errorCount == 0) {
            String ip = httpServletRequest.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                message.setAccessIp("127.0.0.1");
            } else {
                message.setAccessIp(ip);
            }
            boolean add = messageService.save(message);
            if (add) {
                writeRedis();
                return new RespResult<>(200, "留言成功", null, 0L);
            }
            return new RespResult<>(500, "留言失败", null, 0L);
        }
        return new RespResult<>(500, "留言失败", null, 0L);
    }

    /**
     * @param
     * @description:
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 16:32
     */
    @GetMapping("/queryAll")
    public Object queryAll() {
        String key = "messageList";
        Object messageObj = redisTemplate.opsForValue().get(key);
        if (messageObj == null) {
//            加锁、防止多线程访问时出bug
            synchronized (this.getClass()) {
                messageObj = redisTemplate.opsForValue().get(key);
                if (messageObj == null) {
//                    log.error("---->>>>查数据库");
                    QueryWrapper<Message> wrapper = new QueryWrapper<>();
                    wrapper.orderByDesc("id");
                    List<Message> messageList = messageService.list(wrapper);
//                    写入redis
                    redisTemplate.opsForValue().set(key, messageList);
                    return new RespResult<>(200, "查询成功（db）", messageList, 0L);
                } else {
                    return new RespResult(200, "查询成功（redis）", messageObj, 0L);
                }
            }
        }
        return new RespResult<>(200, "查询成功（redis）", messageObj, 0L);
    }


    public void writeRedis() {
        //            增删改查数据之后，进行双写操作、保证数据一致性
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<Message> messageList = messageService.list(wrapper);
        log.error("写缓存");
        redisTemplate.opsForValue().set("messageList", messageList);
    }



}
