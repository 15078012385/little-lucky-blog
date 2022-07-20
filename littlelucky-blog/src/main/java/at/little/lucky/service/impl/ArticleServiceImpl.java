package at.little.lucky.service.impl;

import at.little.lucky.mapper.ArticleMapper;
import at.little.lucky.pojo.Article;
import at.little.lucky.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:14
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public Page findPage(String name, Integer pageNum, Integer pageSize) {
//        条件构造器
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
//            查询该分类的所有文章
            wrapper.eq("category", name);
        }
        return articleMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

}
