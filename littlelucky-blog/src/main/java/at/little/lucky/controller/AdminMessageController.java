package at.little.lucky.controller;

import at.little.lucky.pojo.Message;
import at.little.lucky.service.MessageService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 16:32
 */
@Slf4j
@RestController
@RequestMapping("/admin/message")
public class AdminMessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    public RedisTemplate redisTemplate;


//    @PostMapping("/add")
//    public Object add(@RequestBody Message message) {
//        boolean add = messageService.save(message);
//        if (add) {
//            return new RespResult<>(200, "添加成功", null, 0L);
//        }
//        return new RespResult<>(500, "添加失败", null, 0L);
//    }


    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        boolean delete = messageService.removeById(id);
        if (delete) {
            writeRedis();
            return new RespResult<>(200, "删除成功", null, 0L);
        }
        return new RespResult<>(500, "删除失败", null, 0L);
    }

    @PutMapping("/update")
    public Object update(@RequestBody Message message) {
        boolean update = messageService.updateById(message);
        if (update) {
            writeRedis();
            return new RespResult<>(200, "更新成功", null, 0L);
        }
        return new RespResult<>(500, "更新失败", null, 0L);
    }


    @GetMapping("/queryOne")
    public Object queryOne(Integer id) {
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return new RespResult<>(200, "查询成功", messageService.getOne(wrapper), 0L);
    }


    /**
     * @param pageNum
     * @param pageSize
     * @param search
     * @description: 默认查询第一页，5条记录
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 11:28
     */
    @GetMapping("/queryByPage")
    public Object querymessageByPage(@RequestParam(value = "current", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        Page page = messageService.findPage(search, pageNum, pageSize);
        return new RespResult(200, "查询成功", page.getRecords(), page.getTotal());
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
