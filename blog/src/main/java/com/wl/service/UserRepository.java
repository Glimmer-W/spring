package com.wl.service;

import com.wl.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangl on 2018/11/9 14:14
 */
@Component
public class UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public void saveUser(User user) {
        userMap.put(user.getUserName(), user);
    }

    public User getByUserName(String userName) {
        return  userMap.get(userName);
    }
}
