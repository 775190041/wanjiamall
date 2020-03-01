package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.utils.aliyun.OssUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "图片上传路径")
@RequestMapping("/api")
public class OssMultipartFileUploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        return new OssUtil().uploadDocument(file,"imgs");
    }
}
