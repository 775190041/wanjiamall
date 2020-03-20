package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.ExpressInfo;
import com.nf.wanjiamall.service.impl.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wx")
public class WxExpressController {
    @Autowired
    private ExpressService expressService;
    @RequestMapping("/express/{id}")
    @ResponseBody
    public ExpressInfo getExpress(@PathVariable Integer id)  {
        return expressService.getExpressInfo("ZTO","123456");
    }
}
