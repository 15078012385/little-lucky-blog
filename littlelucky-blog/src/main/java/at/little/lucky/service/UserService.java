package at.little.lucky.service;

import at.little.lucky.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description user服务层
 * @author xiaochen
 * @date 2022-07-16
 */
@Service
public interface UserService extends IService<User> {

    public Page findPage(String name, Integer pageNum, Integer pageSize);

}
