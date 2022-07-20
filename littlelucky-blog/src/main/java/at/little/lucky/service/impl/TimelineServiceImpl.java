package at.little.lucky.service.impl;

import at.little.lucky.mapper.TimelineMapper;
import at.little.lucky.pojo.Timeline;
import at.little.lucky.service.TimelineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:11
 */
@Service
public class TimelineServiceImpl extends ServiceImpl<TimelineMapper, Timeline> implements TimelineService {

    @Autowired
    private TimelineMapper timelineMapper;

    @Override
    public List<Timeline> list() {
        QueryWrapper<Timeline> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return  timelineMapper.selectList(wrapper);
    }

    @Override
    public Page findPage(String name, Integer pageNum, Integer pageSize) {
        QueryWrapper<Timeline> wrapper = new QueryWrapper<>();
//        如果存在条件查询、则带上该条件。
        if (!"".equals(name)) {
            wrapper.eq("", name);
        }
        return timelineMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

}
