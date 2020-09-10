//package com.wyf.web.controller;
//
//
//import com.wyf.web.security.JwtAuthenticatioToken;
//import com.wyf.web.utils.SecurityUtils;
//import com.wyf.web.vo.HttpResult;
//import com.wyf.web.vo.LoginBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
////登录控制器
//@RestController
//public class LoginController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    //登录接口
//    @PostMapping("/login")
//    public HttpResult loogin(@RequestBody LoginBean loginBean, HttpServletRequest request,@RequestParam("remember-me")boolean isRem){
//        String username = loginBean.getUsername();
//        String passowrd = loginBean.getPassword();
//
//        //系统登录认证
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, passowrd, authenticationManager);
//        return HttpResult.ok(token);
//    }
//}
