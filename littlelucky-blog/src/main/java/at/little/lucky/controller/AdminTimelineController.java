package at.little.lucky.controller;

import at.little.lucky.mapper.TimelineMapper;
import at.little.lucky.pojo.Article;
import at.little.lucky.pojo.Message;
import at.little.lucky.pojo.Timeline;
import at.little.lucky.pojo.User;
import at.little.lucky.service.TimelineService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 16:46
 */
@Slf4j
@RestController
@RequestMapping("/admin/timeline")
public class AdminTimelineController {

    @Autowired
    private TimelineService timelineService;

    @Autowired
    public RedisTemplate redisTemplate;

    @PostMapping("/add")
    public Object add(@RequestBody Timeline timeline, HttpSession session) {
        User user = (User) session.getAttribute("user");
        timeline.setNickName(user.getNickname());
        timeline.setCreateTime(new SimpleDateFormat("MM月dd日").format(new Date()));

        boolean add = timelineService.save(timeline);
        if (add) {
            writeRedis();
            return new RespResult<>(200, "新增成功", null, 0L);

        }
        return new RespResult<>(500, "新增失败", null, 0L);
    }

    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        boolean delete = timelineService.removeById(id);
        if (delete) {
            writeRedis();
            return new RespResult<>(200, "删除成功", null, 0L);
        }
        return new RespResult<>(500, "删除失败", null, 0L);
    }

    @PutMapping("/update")
    public Object update(@RequestBody Timeline timeline) {
        boolean update = timelineService.updateById(timeline);
        if (update) {
            writeRedis();
            return new RespResult<>(200, "更新成功", null, 0L);
        }
        return new RespResult<>(500, "更新失败", null, 0L);
    }


    @GetMapping("/queryOne")
    public Object queryOne(Integer id) {
        QueryWrapper<Timeline> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return new RespResult<>(200, "查询成功", timelineService.getOne(wrapper), 0L);
    }


    @GetMapping("/queryAll")
    public Object queryAll() {
//        降序排列
        List<Timeline> timelineList = timelineService.list();
        return new RespResult<>(200, "查询成功", timelineList, 0L);
    }


    public  void writeRedis(){
        //            删除数据之后，进行双写操作、保证数据一致性
        List<Timeline> timelineList = timelineService.list();
        log.error("---->> 写入redis");
//            写入缓存
        redisTemplate.opsForValue().set("timelineList", timelineList);
    }


}
