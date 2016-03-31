package base;

import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.se.api.UserApi;
import org.ligson.se.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ligson on 2016/3/29.
 */
public class BaseTest {
    static ApplicationContext context = new ClassPathXmlApplicationContext
            ("META-INF/spring/spring-conf.xml");
    protected static UserApi userApi = (UserApi) context.getBean("userApi");
    protected static UserService userService = (UserService) context.getBean("userService");
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public void println(Object object) {
        logger.info("{}", object);
    }

    public void testResult(Result result) {
        println(result);
        assert result.isSuccess();
    }
}
