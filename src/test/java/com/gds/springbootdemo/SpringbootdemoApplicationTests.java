package com.gds.springbootdemo;

import com.gds.springbootdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    // 记录日志
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    User user;
    @Test
    public void contextLoads() {
        // 日志级别由低到高

        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }

    @Test
    public void perTest() {
       // System.err.println("年龄："+user.getAge()+", 姓名： "+user.getName()+"，id："+user.getId());
        System.err.println(user);
    }

    @Test
    public void Testc() {
        // System.err.println("年龄："+user.getAge()+", 姓名： "+user.getName()+"，id："+user.getId());
        System.err.println(Test.class);
    }

}
