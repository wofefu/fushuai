package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class UploadController {
    @Value("${project.upload.path}")
    private String path;

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file+"---");
        //所谓的上传文件
        //核心是流
        //细节是存储路径 ----把文件传到那里去
        //把文件存在指定的磁盘目录而不是项目目录
        String fileFullName = path + file.getOriginalFilename();
        System.out.println(fileFullName+"路径");
        try (  //这个小括号会自动关闭资源
                InputStream inputStream = file.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(fileFullName)
        ) {
            //编读编写
            int result;
            while ((result=inputStream.read())!=-1){
                fileOutputStream.write(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
