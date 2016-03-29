package org.ligson.se.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.ligson.fw.biz.AbstractBiz;
import org.ligson.fw.facade.base.dto.BaseRequestDto;
import org.ligson.fw.facade.base.result.Result;
import org.ligson.fw.facade.enums.FailureCodeEnum;
import org.ligson.fw.utils.annotation.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.annotation.Annotation;

/**
 * Created by ligson on 2015/12/18.
 * 所有接口调用统一拦截器
 */
public class BizInterceptor implements MethodInterceptor {
    private static Logger logger = LoggerFactory.getLogger(BizInterceptor.class);
    private static final String PERFIX = "=============>";

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object target = methodInvocation.getThis();
        if (target instanceof AbstractBiz) {
            Class bizClass = target.getClass();
            logger.debug(bizClass.getName());
            Annotation annotation = bizClass.getDeclaredAnnotation(Api.class);
            if (annotation != null) {
                if (annotation instanceof Api) {
                    Api api = (Api) annotation;
                    logger.debug("\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=\\/=");
                    logger.debug("{}开始调用:{}【{}】", PERFIX, api.name(), bizClass.getName());
                    long start = System.currentTimeMillis();
                    Object result;
                    try {
                        Object[] objects = methodInvocation.getArguments();
                        if (objects.length > 0 && objects[0] instanceof BaseRequestDto) {
                            logger.debug("{} {}请求参数:{}", PERFIX, api.name(), objects[0].toString());
                        }
                        result = methodInvocation.proceed();
                        logger.debug("{} {}响应参数:{}", PERFIX, api.name(), result.toString());
                    } catch (Exception e) {
                        logger.error(PERFIX + api.name() + "调用异常:{}", e);
                        result = Result.getFailureResult(FailureCodeEnum.SERVICE_EXCEPTION.getCode(),
                                FailureCodeEnum.SERVICE_EXCEPTION.getMsg() + ";异常信息:" + e);
                        //事物回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    } finally {
                        long end = System.currentTimeMillis();
                        logger.debug("{}调用完成:{}【{}】，耗时{}ms", PERFIX, api.name(), bizClass.getName(), end - start);
                        logger.debug("/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=/\\=");
                    }
                    return result;
                }
            }
        }
        return methodInvocation.proceed();
    }
}
