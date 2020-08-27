package com.wyf.web.service.Impl;

import com.wyf.web.model.User;
import com.wyf.web.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        String password = new BCryptPasswordEncoder().encode("123");
        user.setPassword(password);
        return user;
    }

    @Override
    public Set<String> findPermissions(String username) {
        HashSet<String> permmisions = new HashSet<>();
        permmisions.add("sys:user:view");
        permmisions.add("sys:user:add");
        permmisions.add("sys:user:edit");
        permmisions.add("sys:user:delete");
        return permmisions;
    }
}
