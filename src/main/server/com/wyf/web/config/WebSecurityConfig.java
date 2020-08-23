package com.wyf.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



/*
这个类是SpringSecurity打的关键配置类
在这个配置类中，我们主要做了以下几个配置：
1. 访问路径URL的授权策略，如登录、Swagger访问免登录认证等

2. 指定了登录认证流程过滤器 JwtLoginFilter，由它来触发登录认证

3. 指定了自定义身份认证组件 JwtAuthenticationProvider，并注入 UserDetailsService

4. 指定了访问控制过滤器 JwtAuthenticationFilter，在授权时解析令牌和设置登录状态

5. 指定了退出登录处理器，因为是前后端分离，防止内置的登录处理器在后台进行跳转
*/


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用自定义登录身份认证组件
        auth.authenticationProvider(n)

    }
}

