package at.little.lucky.controller;

import at.little.lucky.pojo.Category;
import at.little.lucky.service.ArticleService;
import at.little.lucky.service.CategoryService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 14:38
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;


//     category.html页面初始化，会同时调用两个api：
//     queryByPage 、queryArticleByPage，前者获取分类，后者获取默认列表文章


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
        Page page = categoryService.findPage(search, pageNum, pageSize);
//        算出页数
//        long pages = (page.getTotal() + pageSize - 1) / pageSize;
//        log.warn("页数：{}", pages);
        return new RespResult(200, "查询成功", page.getRecords(), page.getTotal());
    }

    @GetMapping("/queryAll")
    public Object queryAll() {
        List<Category> categoryList = categoryService.list();
        return new RespResult(200, "查询成功", categoryList, (long) categoryList.size());
    }


//    当点击某一分类时，相当于添加了search条件，调用的是该方法
//    前端用个全局变量、记录当前分类，每次发请求，都会带上该字段。
//    这样可以保证，点击下一页的时候、不会跳到默认文章列表.

    /**
     * @param pageNum
     * @param pageSize
     * @param search
     * @description: 默认查询第一页，5条记录
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 11:28
     */
    @GetMapping("/queryArticleByPage")
    public Object queryArticleByPage(@RequestParam(value = "current", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "category", defaultValue = "") String search) {
        Page page = articleService.findPage(search, pageNum, pageSize);
//        算出页数
//        long pages = (page.getTotal() + pageSize - 1) / pageSize;
//        log.warn("页数：{}", pages);
        return new RespResult(200, "查询成功", page.getRecords(), page.getTotal());
    }


}
