package com.wl.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangl on 2018/11/9 11:35
 */
@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);
    @RequestMapping("/")
    public String home(){
        logger.debug("进入主页============");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/detail")
    @ResponseBody
    public String detail(){
        return "detail";
    }

    @RequestMapping("/{articleId}")
    @ResponseBody
    public String detail(@PathVariable String articleId){
        return articleId;
    }
}
