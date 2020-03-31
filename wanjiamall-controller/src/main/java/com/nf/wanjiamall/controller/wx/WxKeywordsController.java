package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxHotService;
import com.nf.wanjiamall.service.wx.WxKeywordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wx_keywords")
@RequestMapping("/wx")
public class WxKeywordsController {

    @Autowired
    private WxKeywordsService wxKeywordsService;

    @ApiImplicitParams(
            @ApiImplicitParam(name = "keywords", dataType = "String", value = "关键字，必须", required = false)
    )

    @ApiOperation("查询新品推荐的数据")
    @GetMapping("/keywords")
    public Object getNewsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                              @PathVariable(required = false) String keywords){
        return wxKeywordsService.getKeywordsData(pageNum, pageSize, keywords);
    }

}
