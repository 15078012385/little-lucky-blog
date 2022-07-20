package at.little.lucky.service.impl;

import at.little.lucky.mapper.CategoryMapper;
import at.little.lucky.pojo.Article;
import at.little.lucky.pojo.Category;
import at.little.lucky.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Page findPage(String name, Integer pageNum, Integer pageSize) {
        //        条件构造器
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            wrapper.eq("", name);
        }
        return categoryMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

}
