package com.wyf.web.controller;


import com.wyf.web.vo.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//登录控制器
@RestController
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    //登录接口
    @PostMapping("/form")
    public HttpResult loogin(@RequestParam("username")String username,@RequestParam("password")String password, HttpServletRequest request){

        return HttpResult.ok("登录成功");
    }
}
