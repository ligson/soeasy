package org.ligson.soeasy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created by ligso on 2016/1/27.
 *
 * @author ligson
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-conf.xml");
        logger.debug("context:{}---", context);
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }
}
