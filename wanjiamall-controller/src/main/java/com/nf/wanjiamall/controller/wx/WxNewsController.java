package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxBrandService;
import com.nf.wanjiamall.service.wx.WxNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wx_news")
@RequestMapping("/wx")
public class WxNewsController {

    @Autowired
    private WxNewsService wxNewsService;

    @ApiImplicitParams(
            @ApiImplicitParam(name = "cateId", dataType = "Integer", value = "类目ID，必须", required = false)
    )

    @ApiOperation("查询新品推荐的数据")
    @GetMapping("/news")
    public Object getNewsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                              @PathVariable(required = false) Integer cateId){
        return wxNewsService.getNewsData(pageNum, pageSize, cateId);
    }

}
