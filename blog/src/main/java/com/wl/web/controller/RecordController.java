package com.wl.web.controller;

import com.wl.domain.Record;
import com.wl.domain.User;
import com.wl.service.CompanyRepository;
import com.wl.service.RecordRepository;
import com.wl.service.UserRepository;
import com.wl.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/recordManage", method = RequestMethod.GET)
    public String userManage(Model model) {
        model.addAttribute("recordList", recordRepository.getAllRecord());
        return "record/recordManage";
    }


    @RequestMapping(value = "/editRecord", method = RequestMethod.GET)
    public String editUser(Integer id, Model model) {
        Record record;
        if (id != null) {
            record = recordRepository.getById(id);
        } else {
            record = new Record();
        }
        model.addAttribute(record);
        model.addAttribute("userList",userRepository.getAllUser());
        model.addAttribute("companyList",companyRepository.getAll());
        return "record/editRecord";
    }


    @RequestMapping("/save")
    public String save(Record record) {
        recordRepository.save(record);
        return WebUtil.redirect("/record/recordManage");
    }

}
