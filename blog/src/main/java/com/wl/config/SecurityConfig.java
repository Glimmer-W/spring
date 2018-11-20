package com.wl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// 启用Web安全性
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public SecurityConfig() {
        System.out.println("SecurityConfig 被初始化");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启用内存用户存储
        auth.inMemoryAuthentication()
                .withUser("user").password("123").roles("USER").and()
                .withUser("admin").password("123").roles("USER", "ADMIN");
    }


    /**
     * 使用Java配置权限要求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 自定义登录页面
                .formLogin().loginPage("/login").and()
                .authorizeRequests()
                    .antMatchers("/company/manage").hasRole("ADMIN")
                    .antMatchers("/user/userManage").hasRole("ADMIN")
                    .antMatchers("/record/recordManage").hasRole("USER")
                    .and()
                // 启用Remember-me功能
                .rememberMe()
                    // 有效时长
                    .tokenValiditySeconds(60*3)
                    .and()
                // 退出
                .logout()
                    // 此处配置 logoutRequestMatcher 是由于从Spring Security3.2开始，默认就会开启CSRF防护的功能，将会拦截状态为POST状态的请求
                    // 而 logoutRequestMatcher 的默认配置是匹配的post类型的请求，所以需求重新配置
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    // 自定义退出后重定向的路径
                    .logoutSuccessUrl("/")
                    .and();
        // todo 设置seesion 超时 验证【记住我功能】

    }



}
