package com.nf.wanjiamall.controller.advertising;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.service.advertising.AdvertisingService;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "广告管理")
@RequestMapping("/api")
public class AdvertisingController {
    @Autowired
    private AdvertisingService advertisingService;

    @ApiOperation(value = "getAll",notes = "获取广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer")
    })
    @GetMapping("/ad/{pageNum}-{pageSize}")
    public ResponseVo getAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        List<AdvertisingEntity> list = advertisingService.getAll(pageNum,pageSize);
        return ResponseVo.getSuccess("ok",list);
    }

    @ApiOperation(value = "updateAd",notes = "修改广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "要修改广告的ID",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "广告标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "link", value = "广告活动地址",required = false, dataType = "String"),
            @ApiImplicitParam(name = "url", value = "广告图片路径",required = false, dataType = "String"),
            @ApiImplicitParam(name = "position", value = "广告位置",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "广告内容",required = false, dataType = "String"),
            @ApiImplicitParam(name = "add_time", value = "添加时间",required = false, dataType = "timestamp"),
            @ApiImplicitParam(name = "update_time", value = "修改时间",required = false, dataType = "timestamp"),
            @ApiImplicitParam(name = "deleted", value = "是否删除",required = false, dataType = "Integer")
    })
    @PutMapping("/ad/{id}")
    public ResponseVo updateAd(AdvertisingEntity advertisingEntity, @PathVariable Integer id){
        advertisingService.updateAd(advertisingEntity, id);
        return ResponseVo.getSuccess("ok","修改成功！");
    }

}
