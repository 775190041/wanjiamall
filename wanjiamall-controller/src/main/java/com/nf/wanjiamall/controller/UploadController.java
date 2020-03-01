package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.utils.aliyun.OssUtil;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sam
 */
@RestController
@Api(tags = "文件上传服务")
@RequestMapping("/api")
public class UploadController {

    @PostMapping("/upload")
    public ResponseVo upload(MultipartFile file){
        OssUtil ossUtil = new OssUtil();
        String url = ossUtil.uploadDocument(file,"imgs");
        return ResponseVo.getSuccess("ok",url);
    }
}
