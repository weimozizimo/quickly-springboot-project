package com.wyf.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录控制器
@RestController
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("form")
    public String form(HttpServletRequest request,HttpServletResponse response){

        return "";
    }

    @GetMapping("login")
    public ModelAndView login(ModelAndView model){
         model.setViewName("index");
        return model;
    }
}
