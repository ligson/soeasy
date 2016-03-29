package base;

import org.ligson.fw.facade.base.result.Result;
import org.ligson.se.api.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ligson on 2016/3/29.
 */
public class DubboBaseTest {
    private static Logger logger = LoggerFactory.getLogger(DubboBaseTest.class);
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext
            ("spring-conf.xml");
    protected static UserApi userApi = (UserApi) applicationContext.getBean("userApi");

    public void println(Object object) {
        logger.info("{}", object);
    }

    public void testResult(Result result) {
        println(result);
        assert result.isSuccess();
    }
}
