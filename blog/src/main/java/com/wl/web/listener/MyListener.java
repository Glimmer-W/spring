package com.wl.web.listener;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // 设置session超时时间为 30秒
        event.getSession().setMaxInactiveInterval(30);
        System.out.println("session被创建了！");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session超时了！");

    }
}
