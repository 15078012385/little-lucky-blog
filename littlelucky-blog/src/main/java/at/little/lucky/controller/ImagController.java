package at.little.lucky.controller;

import at.little.lucky.service.ImgService;
import at.little.lucky.utils.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/18 22:03
 */
@Slf4j
@RestController
@RequestMapping("/img")
public class ImagController {

    @Autowired
    private ImgService imgService;

    @GetMapping("/queryAll")
    public Object queryAll() {
        return new RespResult<>(200, "查询成功", imgService.list(), 0L);
    }


}
