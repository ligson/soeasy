package org.ligson.se.facade;

import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.se.api.UserApi;
import org.ligson.se.api.dto.*;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;
import org.ligson.se.biz.user.CheckLoginNameBiz;
import org.ligson.se.biz.user.LoginBiz;
import org.ligson.se.biz.user.RegisterBiz;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/3/24.
 * 对外api实现
 */
@Component(value = "userApi")
public class UserApiImpl implements UserApi {

    @Resource
    private LoginBiz loginBiz;

    @Resource
    private RegisterBiz registerBiz;

    @Resource
    private CheckLoginNameBiz checkLoginNameBiz;

    @Override
    public Result<LoginResponseDto> login(LoginRequestDto requestDto) {
        return loginBiz.operation(requestDto);
    }

    @Override
    public Result<RegisterResponseDto> register(RegisterRequestDto requestDto) {
        return registerBiz.operation(requestDto);
    }

    @Override
    public Result<ChkLoginNameValidResponseDto> checkLoginName(ChkLoginNameValidRequestDto requestDto) {
        return checkLoginNameBiz.operation(requestDto);
    }
}
