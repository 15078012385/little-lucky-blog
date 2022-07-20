package at.little.lucky.service;

import at.little.lucky.pojo.Timeline;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description timeline服务层
 * @author xiaochen
 * @date 2022-07-16
 */
@Service
public interface TimelineService extends IService<Timeline> {

    public Page findPage(String name, Integer pageNum, Integer pageSize);

}
