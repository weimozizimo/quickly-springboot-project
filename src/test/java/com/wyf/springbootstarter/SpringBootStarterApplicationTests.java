package com.wyf.springbootstarter;

import com.wyf.SpringBootStarterApplication;
import com.wyf.web.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarterApplication.class)
@EnableAutoConfiguration
class SpringBootStarterApplicationTests {

    @Autowired
    private UserDao dao;

    @Test
    void test1() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String p = encoder.encode("123");
        System.out.println(p);
        String password = "123";
        boolean b = encoder.matches(password, p);
        System.out.println(b);
    }

    @Test
    void test2(){
//        RoleDO role = dao.getRoleByUserId("zimo");
//        System.out.println(role);

    }

}
