package at.little.lucky.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 21:08
 */
@RestController
@RequestMapping("/admin/file")
public class FileController {

    @Value("${files.upload.path}")
    private String fileUploadPath;

//    @PostMapping("/upload")
//    public Object uploadFile(@RequestParam MultipartFile file) throws IOException {
////      获取文件名字
//        String originalFilename = file.getOriginalFilename();
////      获取文件类型
//        String type = FileUtil.extName(originalFilename);
////        生成文件的UUID、也就是唯一的文件名
//        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;
////      文件上传的绝对路径
//        File uploadAbsPath = new File(fileUploadPath + fileUUID);
////        获取父目录，判断是否存在、不存在则创建
//        File parentFile = uploadAbsPath.getParentFile();
//        if (!parentFile.exists()) {
//            parentFile.mkdirs();
//        }
////        定义url，用于返回前端~
//        String url;
//        file.transferTo(uploadAbsPath);
//        url = "http://localhost:8080/upload/" + fileUUID;
//        return new RespResult<>(1, "上传成功", url, null);
//    }


    @PostMapping("/upload")
    public Object uploadFile(@RequestParam MultipartFile file) throws IOException {
//      获取文件名字
        String originalFilename = file.getOriginalFilename();
//      获取文件类型
        String type = FileUtil.extName(originalFilename);
//        生成文件的UUID、也就是唯一的文件名
        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;
//      文件上传的绝对路径
        File uploadAbsPath = new File(fileUploadPath + fileUUID);
//        获取父目录，判断是否存在、不存在则创建
        File parentFile = uploadAbsPath.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
//        定义url，用于返回前端~
        String url;
        file.transferTo(uploadAbsPath);
//        上传回显主机地址在这！
        return url = "http://120.48.97.96/file/" + fileUUID;
    }


}
