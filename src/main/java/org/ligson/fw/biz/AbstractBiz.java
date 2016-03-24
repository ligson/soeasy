package org.ligson.fw.biz;

import org.ligson.fw.biz.model.Context;
import org.ligson.fw.facade.base.dto.BaseRequestDto;
import org.ligson.fw.facade.base.dto.BaseResponseDto;
import org.ligson.fw.facade.base.result.Result;
import org.ligson.fw.facade.enums.FailureCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * 抽象业务类
 */
@SuppressWarnings("unused")
public abstract class AbstractBiz<Q extends BaseRequestDto, R extends BaseResponseDto> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractBiz.class);
    protected Context context = new Context();
    protected Q requestDto;
    protected R responseDto;

    /**
     * 初始化通用信息：
     */
    private void init() {
        context.setBusinessDate(new Date());
        context.setCurrentDate(new Date());
        before();
    }

    /**
     * 核心业务入口方法
     *
     * @param dto 请求的dto
     */
    public Result<R> operation(Q dto) {
        requestDto = dto;
        setResponseDto();
        return result();
    }

    /**
     * 前置方法
     */
    public abstract void before();

    /**
     * 参数检查
     */
    public abstract Boolean paramCheck();

    /**
     * 业务检查
     */
    public abstract Boolean bizCheck();

    /**
     * 数据预处理
     */
    public abstract Boolean txnPreProcessing();

    /**
     * 数据存储
     */
    public abstract Boolean persistence();

    /**
     * 后置方法
     */
    public abstract void after();

    @SuppressWarnings("unchecked")
    public Result<R> result() {

        try {
            //初始化
            init();
            //交易处理
            operate();

        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            if (context.getResult() == null) {
                setFailureResult(FailureCodeEnum.SERVICE_EXCEPTION);
            }
        } finally {
            Assert.notNull(context.getResult(), "返回结果不能为空");
            try {
                //后置业务处理
                after();
            } catch (Exception e) {
                logger.error("后置业务处理异常.", e);
            }
        }

        return context.getResult();
    }

    /**
     * 业务处理
     */
    private void operate() {
        Boolean paramCheck;
        Boolean bizCheck;
        Boolean txnPreProcessing;
        Boolean persistence;
        logger.debug("======================>参数检查开始");
        paramCheck = paramCheck();
        if (paramCheck != null && !paramCheck) {
            logger.debug("======================>参数检查失败,开始返回");
            return;
        }
        logger.debug("======================>参数检查成功");
        logger.debug("======================>业务检查开始");
        bizCheck = bizCheck();
        if (bizCheck != null && !bizCheck) {
            logger.debug("======================>业务检查失败,开始返回");
            return;
        }
        logger.debug("======================>业务检查成功");
        logger.debug("======================>业务处理开始");
        txnPreProcessing = txnPreProcessing();
        if (txnPreProcessing != null && !txnPreProcessing) {
            logger.debug("======================>业务处理完成,开始返回");
            return;
        }
        logger.debug("======================>业务处理完成");
        logger.debug("======================>持久化开始");
        persistence = persistence();
        if (persistence != null && !persistence) {
            logger.debug("======================>持久化完成,开始返回");
            return;
        }
        logger.debug("======================>持久化完成");
    }


    @SuppressWarnings("rawtypes")
    private Class getGenericType(int index) {
        Type genType = getClass().getGenericSuperclass();
        logger.debug("=================>处理请求:{}", genType.getTypeName());
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    public void setSuccessResult() {
        Result<R> responseDtoResult = Result.getSuccessResult(responseDto);
        context.setResult(responseDtoResult);
    }

    public void setFailureResult(FailureCodeEnum failureCodeEnum) {
        Result<R> result = Result.getFailureResult(failureCodeEnum);
        context.setResult(result);
    }

    @SuppressWarnings("unchecked")
    private void setResponseDto() {
        Class<R> rCls = getGenericType(1);
        try {
            responseDto = rCls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
