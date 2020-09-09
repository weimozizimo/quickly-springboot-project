package com.wyf.web.config;

import com.wyf.web.filter.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;



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

    @Autowired
    private UserDetailsService userDetailsService;



    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用自定义登录身份认证组件
//        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
        //使用默认的登录身份认证组件
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf，由于使用的jwt所有这里不需要csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                //跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //登录url
                .antMatchers("/login").permitAll()
                //swagger
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll() //这个是允许加载bootstrap前端文件
                .antMatchers("/v2/**").permitAll()
                //其他所有请求需要身份认证
                .anyRequest().authenticated();
        //退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        //开启登录认证流程过滤器
        //使用自定义登录认证过滤器所以，注释掉这段代码
        http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

        http.rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600)
                .userDetailsService(userDetailsService)
                .rememberMeServices(new PersistentTokenBasedRememberMeServices("rm",userDetailsService,persistentTokenRepository()));
        //访问控制时登录状态检查过滤器
        //如果强制要求需要请求头携带token发送请求时解除该行注释
//        http.addFilterBefore(new JwtAuthticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        // 将 DataSource 设置到 PersistentTokenRepository
        persistentTokenRepository.setDataSource(dataSource);
        // 第一次启动的时候自动建表（可以不用这句话，自己手动建表，源码中有语句的）
        // persistentTokenRepository.setCreateTableOnStartup(true);
        return persistentTokenRepository;
    }
}

