package com.wl.web;

import com.wl.domain.User;
import com.wl.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * 用户注册
 * Created by wangl on 2018/11/9 13:50
 */
@Controller()
@RequestMapping("/register")
public class RegisterController {
    @Value("${file.upload.path}")
    private  String fileUploadPath;

    @Autowired
    private UserRepository userRepository;

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String goToRegisterPage(){
        return "register";
    }

    /**
     * 处理注册信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processRegisterInfo(@Valid User user, @RequestPart("headPhoto") MultipartFile headPhoto, Errors errors){
        System.out.println("上传文件大小：" + headPhoto.getSize());
        try {
            File file = new File(fileUploadPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            user.setHeadPhotoImageName(headPhoto.getOriginalFilename());
            headPhoto.transferTo(new File(file, headPhoto.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (errors.hasErrors()) {
            return "register";
        }
        userRepository.saveUser(user);
        // 重定向到用户详情展示页面
        return "redirect:/setting/account/" + user.getUserName();
    }
}
