package com.wl.service;

import com.wl.domain.Company;
import com.wl.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2018/11/9 14:14
 */
@Component
public class CompanyRepository {
    private final Map<Integer, Company> map = new HashMap<>();

    public void save(Company company) {
        map.put(company.getId(), company);
    }

    public Company getById(int id){
        return map.get(id);
    }

    public List<Company> getAll(){
        List<Company> list = new ArrayList<>();
        for (Map.Entry<Integer, Company> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
