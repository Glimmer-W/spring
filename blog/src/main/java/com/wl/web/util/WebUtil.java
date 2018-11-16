package com.wl.web.util;

/**
 * Created by wangl on 2018/11/16 09:55
 */
public class WebUtil {

    public static String redirect(String url) {
        if (url == null) {
            throw new IllegalArgumentException("'url' can't be null!");
        }
        return "redirect:" + url;
    }

}
