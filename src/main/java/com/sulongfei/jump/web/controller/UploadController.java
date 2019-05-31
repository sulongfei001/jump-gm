package com.sulongfei.jump.web.controller;

import com.google.common.collect.Maps;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.utils.AliyunUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/26 11:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/file")
@Slf4j
public class UploadController {

    @PostMapping("/upload")
    public Response<Map<String,String>> upload(@RequestParam  MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String url = AliyunUpload.uploadToStream(inputStream, originalFilename);
        log.info("文件上传的URL = {}", url);
        Map<String, String> result = Maps.newConcurrentMap();
        result.put("name", originalFilename);
        result.put("url", url);
        return new Response<>(result);
    }
}
