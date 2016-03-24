package org.ligson.soeasy.test;

import org.ligson.fw.entity.Pagination;
import org.ligson.soeasy.entity.UserEntity;
import org.ligson.soeasy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
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
    static UserService userService = (UserService) context.getBean("userService");

    public static void insert() throws Exception {
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("user--" + i);
            userEntity.setBirth(new Date());
            userEntity.setPassword("password");
            userEntity.setSex(true);
            userEntity.setStatus(1);
            userService.add(userEntity);
            Thread.sleep(10);
            System.out.println(userEntity);
        }
    }

    public static void query() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setPageNum(1);
        userEntity.setOffset(0);
        userEntity.setMax(10);
        //userEntity.setSex(true);
        // userEntity.setStatus(1);
        Pagination<UserEntity> pagination = userService.findAllBy(userEntity);
        System.out.println(pagination.getTotalCount());
        System.out.println(pagination.getDatas());
        for (UserEntity entity : pagination.getDatas()) {
            //System.out.println(entity.getp);
        }
        //List<UserEntity> entity = userService.find(new UserEntity());
        //System.out.println(entity);
    }

    public static void get() {
        //2016032117550140
        UserEntity entity = userService.get(new BigInteger("2016032117550140"));
        System.out.println(entity);
    }

    public static void main(String[] args) throws Exception {
        //query();
        //insert();
        get();
    }
}
