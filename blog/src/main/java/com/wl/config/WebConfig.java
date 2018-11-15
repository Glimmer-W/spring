package com.wl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by wangl on 2018/11/12 11:33
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.wl.web")
// 声明属性源
@PropertySource("classpath:config/application.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置处理multipart请求数据的解析器(必须配置)
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    /**
     * 为了使用占位符，必须配置
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
