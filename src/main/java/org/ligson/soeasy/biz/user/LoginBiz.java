package org.ligson.soeasy.biz.user;

import org.ligson.fw.biz.AbstractBiz;
import org.ligson.fw.biz.paramcheck.CommonParamCheck;
import org.ligson.fw.facade.enums.FailureCodeEnum;
import org.ligson.fw.utils.annotation.Api;
import org.ligson.soeasy.api.dto.LoginRequestDto;
import org.ligson.soeasy.api.dto.LoginResponseDto;
import org.ligson.soeasy.api.enums.FailCodeEnum;
import org.ligson.soeasy.api.enums.user.LoginNameTypeEnum;
import org.ligson.soeasy.entity.UserEntity;
import org.ligson.soeasy.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/3/24.
 *
 * @author 登录业务
 */
@Component(value = "loginBiz")
@Api(name = "用户登录接口")
public class LoginBiz extends AbstractBiz<LoginRequestDto, LoginResponseDto> {

    @Resource
    private UserService userService;

    @Override
    public void before() {

    }

    @Override
    public Boolean paramCheck() {
        if (StringUtils.isEmpty(requestDto.getLoginName())) {
            setFailureResult(FailCodeEnum.E_PARAM_10001);
            return false;
        }
        if (requestDto.getLoginNameTypeEnum() == null) {
            setFailureResult(FailCodeEnum.E_PARAM_1008);
            return false;
        }
        if (requestDto.getLoginNameTypeEnum().equals(LoginNameTypeEnum.EMAIL)) {
            if (!CommonParamCheck.isValidEmail(requestDto.getLoginName(), context, responseDto.getClass())) {
                return false;
            }
        }
        if (requestDto.getLoginNameTypeEnum().equals(LoginNameTypeEnum.MOBILE)) {
            if (!CommonParamCheck.isValidMobile(requestDto.getLoginName(), context, responseDto.getClass())) {
                return false;
            }
        }
        if (StringUtils.isEmpty(requestDto.getPassword())) {
            setFailureResult(FailureCodeEnum.E_PARAM_10003);
            return false;
        }
        return true;
    }

    @Override
    public Boolean bizCheck() {
        UserEntity entity = new UserEntity();
        if (requestDto.getLoginNameTypeEnum().equals(LoginNameTypeEnum.NAME)) {
            entity.setName(requestDto.getLoginName());
        } else if (requestDto.getLoginNameTypeEnum().equals(LoginNameTypeEnum.MOBILE)) {
            entity.setMobile(requestDto.getLoginName());
        } else if (requestDto.getLoginNameTypeEnum().equals(LoginNameTypeEnum.EMAIL)) {
            entity.setEmail(requestDto.getLoginName());
        }
        entity.setPassword(requestDto.getPassword());
        entity = userService.findBy(entity);
        responseDto.setSuccess(entity != null);
        setSuccessResult();
        return true;
    }

    @Override
    public Boolean txnPreProcessing() {
        return null;
    }

    @Override
    public Boolean persistence() {
        return null;
    }

    @Override
    public void after() {

    }
}
