package at.little.lucky.controller;

import at.little.lucky.pojo.Img;
import at.little.lucky.service.ImgService;
import at.little.lucky.utils.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/18 22:03
 */
@Slf4j
@RestController
@RequestMapping("/admin/img")
public class AdminImagController {

    @Autowired
    private ImgService imgService;

    @Autowired
    private FileController fileController;

    @PostMapping("/add")
    public Object add(@RequestParam MultipartFile file) throws IOException {
        Object url = fileController.uploadFile(file);
        Img img = new Img();
        img.setAddTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        img.setImgUrl(url.toString());
        imgService.save(img);
        return url;
    }

    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        boolean delete = imgService.removeById(id);
        if (delete) {
            return new RespResult<>(200, "删除成功", null, 0L);
        }
        return new RespResult<>(500, "删除失败", null, 0L);
    }

    @GetMapping("/queryAll")
    public Object queryAll() {
        return new RespResult<>(200, "查询成功", imgService.list(), 0L);
    }


}
