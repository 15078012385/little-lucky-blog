package at.little.lucky.service.impl;

import at.little.lucky.mapper.UserMapper;
import at.little.lucky.pojo.User;
import at.little.lucky.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page findPage(String name, Integer pageNum, Integer pageSize) {
        return null;
    }
}
