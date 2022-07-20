package at.little.lucky.service;

import at.little.lucky.pojo.Message;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description message服务层
 * @author xiaochen
 * @date 2022-07-16
 */
@Service
public interface MessageService extends IService<Message> {
    public Page findPage(String name, Integer pageNum, Integer pageSize);
}
