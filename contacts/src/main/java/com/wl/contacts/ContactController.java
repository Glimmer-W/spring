package com.wl.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submit(){
        return "redirect:/";
    }
}
