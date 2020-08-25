package com.wyf.web.filter;

import com.wyf.web.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//访问接口的时候，登录认证检查过滤器 JwtAuthenticationFilter 会拦截请求校验令牌和登录状态，并根据情况设置登录状态。
public class JwtAuthticationFilter extends BasicAuthenticationFilter {

    @Autowired
    public JwtAuthticationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //获取token,并检查登录状态
        SecurityUtils.checkAuthentication(request);
        chain.doFilter(request,response);
    }
}
