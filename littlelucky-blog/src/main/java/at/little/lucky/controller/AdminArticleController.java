package at.little.lucky.controller;

import at.little.lucky.pojo.Article;
import at.little.lucky.pojo.User;
import at.little.lucky.service.ArticleService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 16:32
 */
@Slf4j
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public Object add(@RequestBody Article article, HttpSession session) {
        User user = (User) session.getAttribute("user");
        article.setUserId(user.getId());
        article.setUserNickname(user.getNickname());
        article.setUserAvatar(user.getAvatar());
        article.setCreateTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        boolean add = articleService.save(article);
        if (add) {
            return new RespResult<>(200, "添加成功", null, 0L);
        }
        return new RespResult<>(500, "添加失败", null, 0L);
    }


    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        boolean delete = articleService.removeById(id);
        if (delete) {
            return new RespResult<>(200, "删除成功", null, 0L);
        }
        return new RespResult<>(500, "删除失败", null, 0L);
    }

    @PutMapping("/update")
    public Object update(@RequestBody Article article) {
        article.setUpdateTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        boolean update = articleService.updateById(article);
        if (update) {
            return new RespResult<>(200, "更新成功", null, 0L);
        }
        return new RespResult<>(500, "更新失败", null, 0L);
    }

    @GetMapping("/queryOne")
    public Object queryOne(Integer id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return new RespResult<>(200, "查询成功", articleService.getOne(wrapper), 0L);
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
    public Object queryArticleByPage(@RequestParam(value = "current", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        Page page = articleService.findPage(search, pageNum, pageSize);
//        算出页数
//        long pages = (page.getTotal() + pageSize - 1) / pageSize;
//        log.warn("页数：{}", pages);
        return new RespResult(200, "查询成功", page.getRecords(), page.getTotal());
    }


}
