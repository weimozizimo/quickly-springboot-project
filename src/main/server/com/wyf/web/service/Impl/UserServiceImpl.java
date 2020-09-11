package com.wyf.web.service.Impl;

import com.wyf.web.dao.UserDao;
import com.wyf.web.model.AuthorityDO;
import com.wyf.web.model.RoleDO;
import com.wyf.web.model.User;
import com.wyf.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {

        Assert.notNull(username,"用户名为null");

        User user = userDao.getUserByUsername(username);

        if(user==null){
            user = new User();
        }

        return user;
    }

    @Override
    public Set<String> findPermissions(String username) {

        Assert.notNull(username,"用户名为null");

        HashSet<String> permmisions = new HashSet<>();

        //添加权限
        List<RoleDO> roles = userDao.getRoleByUserId(username);
        if(roles==null){
            return permmisions;
        }else {
            for (RoleDO role:roles
                 ) {
                if(role.getAuthorities()==null){
                    continue;
                }else{
                    //添加权限
                    List<AuthorityDO> authorities = role.getAuthorities();
                    authorities.forEach((auth)->{
                        if(!permmisions.contains(auth.getName())){
                            permmisions.add(auth.getName());
                        }});
                }
                if(role.getName()!=null){
                    //添加身份
                    permmisions.add(role.getName());
                }
            }
        }

        return permmisions;
    }

}
