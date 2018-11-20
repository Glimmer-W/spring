package com.wl.config;

import com.wl.web.filter.MyFilter;
import com.wl.web.listener.MyListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.*;

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
        return new Filter[]{encodingFilter, new MyFilter()};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("log4jConfigLocation", "classpath:config/log4j.properties");
        // 添加监听器
        servletContext.addListener(MyListener.class);
        servletContext.addListener(Log4jConfigListener.class);
    }

}
