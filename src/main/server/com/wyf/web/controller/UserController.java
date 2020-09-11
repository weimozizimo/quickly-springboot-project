package com.wyf.web.controller;

import com.wyf.web.vo.HttpResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*@description 用户控制器
*@author weiyifei
*@date 2020/8/27
*/
@RequestMapping("/")
@RestController
public class UserController {

    @GetMapping(value="product/view")
    public HttpResult findAll() {
        return HttpResult.ok("the findAll service is called success.");
    }

    //获取当前登录用户信息
    @GetMapping(value = "product/info")
    public String productInfo(){
        String currentUser =  "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getDetails();
        if(principal instanceof UserDetails){
            currentUser = ((UserDetails) principal).getUsername();
        }else{
            currentUser = principal.toString();
        }
        return "current Login User is " + currentUser;
    }


    @GetMapping(value="admin/edit")
    public HttpResult edit() {
        return HttpResult.ok("the edit service is called success.");
    }

    @GetMapping(value="/delete")
    public HttpResult delete() {
        return HttpResult.ok("the delete service is called success.");
    }
}
