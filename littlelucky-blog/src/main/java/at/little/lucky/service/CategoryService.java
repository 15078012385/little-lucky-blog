package at.little.lucky.service;

import at.little.lucky.pojo.Category;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description category服务层
 * @author xiaochen
 * @date 2022-07-16
 */
public interface CategoryService extends IService<Category> {
    public Page findPage(String name, Integer pageNum, Integer pageSize);

}
