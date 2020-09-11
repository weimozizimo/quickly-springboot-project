package com.wyf.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf，由于使用的jwt所有这里不需要csrf
        http
                .authorizeRequests() //配置需要拦截的请求路径
                .anyRequest().authenticated() //所有请求都需要进行权限验证
                .and()
                .formLogin() //使用表单验证
                .and()
                .rememberMe()
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(3600)
                .tokenRepository();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //内存的登录验证方式
//        auth.inMemoryAuthentication()
//               .withUser("admin")
//                .password("{noop}123")
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("admin2")
//                .password("{noop}123")
//                .roles("USER");
        //数据的登录验证方式
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }


}

