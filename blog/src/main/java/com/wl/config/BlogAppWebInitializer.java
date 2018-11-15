package com.wl.config;

import com.wl.web.filter.MyFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by wangl on 2018/11/12 11:00
 */
public class BlogAppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.err.println("============================被调用了！");
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // 配置处理multipart请求数据(必须配置)
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }

    @Override
    protected Filter[] getServletFilters() {
        /**
         * 使用Filter处理中文乱码
         */
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[]{new MyFilter(), encodingFilter};
    }


}
