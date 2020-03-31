package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxHotService;
import com.nf.wanjiamall.service.wx.WxNewsService;
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
@Api(tags = "wx_hot")
@RequestMapping("/wx")
public class WxHotController {

    @Autowired
    private WxHotService wxHotService;

    @ApiOperation("查询新品推荐的数据")
    @GetMapping("/hot")
    public Object getNewsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        return wxHotService.getHotData(pageNum, pageSize);
    }

}
