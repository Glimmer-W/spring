package com.wl.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by wangl on 2018/11/12 11:50
 */
@Configuration
@ComponentScan(
        basePackages = {"com.wl"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)

public class RootConfig {
}
