package com.wl.web.controller;

import com.wl.web.view.ImageView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;


@Controller
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.path}")
    private String fileUploadPath;


    @RequestMapping("/getFile")
    public ModelAndView getFile(String fileName) throws FileNotFoundException {
        return new ModelAndView(new ImageView(fileUploadPath, fileName));
    }

}
