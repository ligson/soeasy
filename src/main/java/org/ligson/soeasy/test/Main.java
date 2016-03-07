package org.ligson.soeasy.test;

import org.ligson.soeasy.entity.UserEntity;
import org.ligson.soeasy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

/**
 * Created by ligso on 2016/1/27.
 *
 * @author ligson
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    static ApplicationContext context = new ClassPathXmlApplicationContext
            ("META-INF/spring/spring-conf.xml");
    static UserService userService = (UserService) context.getBean("userServiceImpl");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("user--" + i);
            userEntity.setBirth(new Date());
            userEntity.setPassword("password");
            userEntity.setStatus(1);
            userEntity = userService.register(userEntity);
            System.out.println(userEntity);
        }

    }
}
