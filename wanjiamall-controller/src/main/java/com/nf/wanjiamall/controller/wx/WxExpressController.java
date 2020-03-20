package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.ExpressInfo;
import com.nf.wanjiamall.service.impl.ExpressService;
import com.nf.wanjiamall.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wx")
public class WxExpressController {
    @Autowired
    private ExpressService expressService;
    @RequestMapping("/express/{id}")
    public ExpressInfo getExpress(@PathVariable Integer id)  {
        return expressService.getExpressInfo("ZTO","123456");
    }

}
