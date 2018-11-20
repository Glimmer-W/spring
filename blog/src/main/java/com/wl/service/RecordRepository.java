package com.wl.service;

import com.wl.domain.Company;
import com.wl.domain.Record;
import com.wl.domain.User;
import com.wl.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2018/11/9 14:14
 */
@Component
public class RecordRepository {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;


    private final Map<Integer, Record> map = new HashMap<>();

    public void save(Record record) {
        map.put(record.getId(), record);
    }

    public Record getById(Integer id){
        return map.get(id);
    }

    public List<Record> getAll(){
        List<Record> list = new ArrayList<>();
        for (Map.Entry<Integer, Record> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public List<RecordVO> getAllRecord(){
        List<RecordVO> list = new ArrayList<>();
        for (Map.Entry<Integer, Record> entry : map.entrySet()) {
            Record record = entry.getValue();
            RecordVO vo = new RecordVO();
            Company company = companyRepository.getById(record.getCompanyId());
            vo.setId(company.getId());
            vo.setCompanyName(company.getName());
            vo.setBuildDate(company.getBuildAccountDate());
            User user = userRepository.getById(record.getOuterId());
            vo.setOuterName(user.getName());
            user = userRepository.getById(record.getAccountantId());
            vo.setAccountantName(user.getName());
            vo.setCreateDate(record.getCreateDate());
            vo.setNumber(record.getNumber());
            list.add(vo);
        }
        return list;
    }
}
