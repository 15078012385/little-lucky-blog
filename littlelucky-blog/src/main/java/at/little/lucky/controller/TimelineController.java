package at.little.lucky.controller;

import at.little.lucky.pojo.Timeline;
import at.little.lucky.service.TimelineService;
import at.little.lucky.utils.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 15:55
 */
@Slf4j
@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * @param
     * @description:
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 16:32
     */
    @GetMapping("/queryAll")
    public Object queryAll() {
        String key = "timelineList";
        Object timeObj = redisTemplate.opsForValue().get(key);
        if (timeObj == null) {
//            加锁、防止多线程访问时出bug
            synchronized (this.getClass()) {
                timeObj = redisTemplate.opsForValue().get(key);
                if (timeObj == null) {
//                    log.error("---->>>>查数据库");
                    List<Timeline> timelineList = timelineService.list();
                    redisTemplate.opsForValue().set(key, timelineList);
//                    把查到的数据返回
                    return new RespResult(200, "查询成功（db）", timelineList, 0L);
                } else {
//                    log.error("---->>>> 查询缓存(同步代码块)");
                    return new RespResult(200, "查询成功（redis）", timeObj, 0L);
                }
            }
        }
        return new RespResult(200, "查询成功（redis）", timeObj, 0L);
    }

}
