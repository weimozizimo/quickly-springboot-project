package com.wyf.web.dao;

import com.wyf.web.model.RoleDO;
import com.wyf.web.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    //根据用户名查询用户
    User getUserByUsername(@Param("username") String username);
    //根据用户名获取用户角色以及权限
    RoleDO getRoleByUserId(@Param("username") String username);

}
