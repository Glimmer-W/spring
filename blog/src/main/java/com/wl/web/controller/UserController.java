package com.wl.web.controller;

import com.wl.domain.User;
import com.wl.service.UserRepository;
import com.wl.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/userManage", method = RequestMethod.GET)
    public String userManage(Model model) {
        model.addAttribute("userList", userRepository.getAllUser());
        return "user/userManage";
    }


    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(Integer id, Model model) {
        User user;
        if (id != null) {
            user = userRepository.getById(id);
        } else {
            user = new User();
        }
        model.addAttribute(user);
        return "user/editUser";
    }


    @RequestMapping("/save")
    public String save(User user) {
        userRepository.saveUser(user);
        return WebUtil.redirect("/user/userManage");
    }

}
