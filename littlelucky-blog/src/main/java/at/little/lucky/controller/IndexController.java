package at.little.lucky.controller;

import at.little.lucky.pojo.Article;
import at.little.lucky.service.ArticleService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:20
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/queryOne")
    public Object queryOne(Integer id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Article one = articleService.getOne(wrapper);
//        查询一次，浏览量+1
        Integer views = one.getViews();
        views++;
        one.setViews(views);
        articleService.updateById(one);

        return new RespResult<>(200, "查询成功", one, 0L);
    }

    /**
     * @param pageNum
     * @param pageSize
     * @param search
     * @description: 默认查询第一页，5条记录
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 11:28
     */
    @GetMapping("/queryByPage")
    public Object queryByPage(@RequestParam(value = "current", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, @RequestParam(value = "search", defaultValue = "") String search) {
        Page page = articleService.findPage(search, pageNum, pageSize);
//        算出页数
//        long pages = (page.getTotal() + pageSize - 1) / pageSize;
//        log.warn("页数：{}", pages);
        return new RespResult(200, "查询成功", page.getRecords(), page.getTotal());
    }


}
