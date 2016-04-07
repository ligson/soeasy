package org.ligson.se.biz.user;

import org.ligson.fw.core.biz.AbstractBiz;
import org.ligson.fw.core.facade.annotation.Api;
import org.ligson.se.api.dto.ChkLoginNameValidRequestDto;
import org.ligson.se.api.dto.ChkLoginNameValidResponseDto;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;
import org.ligson.se.entity.UserEntity;
import org.ligson.se.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/4/7.
 * 用户登录接口
 */
@Component(value = "loginBiz")
@Api(name = "用户登录接口")
public class CheckLoginNameBiz extends AbstractBiz<ChkLoginNameValidRequestDto, ChkLoginNameValidResponseDto> {

    @Resource
    private UserService userService;

    @Override
    public void before() {

    }

    @Override
    public Boolean paramCheck() {
        return null;
    }

    @Override
    public Boolean bizCheck() {
        return null;
    }

    @Override
    public Boolean txnPreProcessing() {
        LoginNameTypeEnum loginNameType = requestDto.getLoginNameTypeEnum();
        int n = 1;
        UserEntity entity = new UserEntity();
        if (LoginNameTypeEnum.NAME.equals(loginNameType)) {
            entity.setName(requestDto.getLoginName());
            n = userService.countBy(entity);
        } else if (LoginNameTypeEnum.MOBILE.equals(loginNameType)) {
            entity.setName(requestDto.getLoginName());
            n = userService.countBy(entity);
        } else if (LoginNameTypeEnum.EMAIL.equals(loginNameType)) {
            entity.setName(requestDto.getLoginName());
            n = userService.countBy(entity);
        }
        responseDto.setSuccess(n == 0);
        setSuccessResult();
        return true;
    }

    @Override
    public Boolean persistence() {
        return null;
    }

    @Override
    public void after() {

    }
}
