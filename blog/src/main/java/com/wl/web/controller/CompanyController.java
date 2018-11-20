package com.wl.web.controller;

import com.wl.domain.Company;
import com.wl.service.CompanyRepository;
import com.wl.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public String manage(Model model){
        model.addAttribute("companyList", companyRepository.getAll());
        return "company";
    }

    /**
     * 编辑公司信息
     * @param id 公司编号
     * @return
     */
    @RequestMapping(value = "/editCompany", method = RequestMethod.GET)
    public String editCompany(Integer id, Model model){
        Company company;
        if (id != null) {
            company = companyRepository.getById(id);
        } else {
            company = new Company();
        }
        model.addAttribute(company);
        return "maintianCompany";
    }

    /**
     * 保存公司信息
     * @param company 公司信息
     * @return
     */
    @RequestMapping("/saveCompany")
    public String saveCompany(Company company){
        companyRepository.save(company);
        return WebUtil.redirect("/company/manage");
    }

}
