package at.little.lucky.controller;

import at.little.lucky.pojo.Article;
import at.little.lucky.pojo.Category;
import at.little.lucky.service.CategoryService;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 14:38
 */
@Slf4j
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Object add(@RequestBody Category category) {
        category.setCreateTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        boolean add = categoryService.save(category);
        if (add) {
            return new RespResult<>(200, "新增成功", null, 0L);
        }
        return new RespResult<>(500, "新增失败", null, 0L);
    }

    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        boolean delete = categoryService.removeById(id);
        if (delete) {
            return new RespResult<>(200, "删除成功", null, 0L);
        }
        return new RespResult<>(500, "删除失败", null, 0L);
    }


    @PutMapping("/update")
    public Object update(@RequestBody Category category) {
        category.setModifyTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        boolean update = categoryService.updateById(category);
        if (update) {
            return new RespResult<>(200, "修改成功", null, 0L);
        }
        return new RespResult<>(500, "修改失败", null, 0L);
    }

    @GetMapping("/queryOne")
    public Object queryOne(Integer id) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return new RespResult<>(200, "查询成功", categoryService.getOne(wrapper), 0L);
    }


    @GetMapping("/queryAll")
    public Object queryAll() {
        return new RespResult<>(200, "查询成功", categoryService.list(), 0L);
    }

}
