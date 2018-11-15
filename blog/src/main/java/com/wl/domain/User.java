package com.wl.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by wangl on 2018/11/9 14:05
 */
public class User {
    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    private String userName;

    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    private String headPhotoBase64;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPhotoBase64() {
        return headPhotoBase64;
    }

    public void setHeadPhotoBase64(String headPhotoBase64) {
        this.headPhotoBase64 = headPhotoBase64;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
