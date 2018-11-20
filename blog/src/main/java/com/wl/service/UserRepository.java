package com.wl.service;

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
public class UserRepository {
    private final Map<Integer, User> userMap = new HashMap<>();

    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getById(Integer id) {
        return  userMap.get(id);
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
