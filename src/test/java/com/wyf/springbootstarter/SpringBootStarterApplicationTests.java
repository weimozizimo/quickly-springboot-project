package com.wyf.springbootstarter;

import com.wyf.SpringBootStarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarterApplication.class)
@EnableAutoConfiguration
public class SpringBootStarterApplicationTests {

    @Test
    public void test1() {
        System.out.println("123");
    }

}
