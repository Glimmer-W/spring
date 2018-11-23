package com.wl.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "home";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submit(){
        return "redirect:/";
    }
}
