package com.wyf.web.service;

import com.wyf.web.model.User;

import java.util.Set;

public interface UserService {
    /**
    * @Description: 根据用户名查找用户
    * @Param: [username]
    * @return: com.wyf.web.model.User
    * @Author: weiyifei
    * @Date: 2020/8/27 15:49
    */
    User findByUsername(String username);

    /**
    * @Description: 根据用户名获取权限标识集合
    * @Param: [username]
    * @return: java.util.Set<java.lang.String>
    * @Author: weiyifei
    * @Date: 2020/8/27 15:50
    */
    Set<String> findPermissions(String username);
}
