package com.wl.web;

import com.wl.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangl on 2018/11/9 11:35
 */
@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/account/{userName}")
    public String account(@PathVariable String userName, Model model){
        model.addAttribute("user", userRepository.getByUserName(userName));
        return "account";
    }

}
