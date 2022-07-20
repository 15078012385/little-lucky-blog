package at.little.lucky.service.impl;

import at.little.lucky.mapper.MessageMapper;
import at.little.lucky.pojo.Message;
import at.little.lucky.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:13
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Page findPage(String name, Integer pageNum, Integer pageSize) {
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            wrapper.eq("", name);
        }
        return messageMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

}
