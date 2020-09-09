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

        RoleDO role = userDao.getRoleByUserId(username);
        if(role==null){
            return permmisions;
        }else {
            if(role.getAuthorities()==null){
                return permmisions;
            }else{
                List<AuthorityDO> authorities = role.getAuthorities();
                authorities.forEach((auth)->{permmisions.add(auth.getName());});
            }
        }

        return permmisions;
    }
}
