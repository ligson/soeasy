package org.ligson.se.facade;

import org.ligson.fw.facade.base.result.Result;
import org.ligson.se.api.UserApi;
import org.ligson.se.api.dto.LoginRequestDto;
import org.ligson.se.api.dto.LoginResponseDto;
import org.ligson.se.api.dto.RegisterRequestDto;
import org.ligson.se.api.dto.RegisterResponseDto;
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

    @Override
    public Result<LoginResponseDto> login(LoginRequestDto requestDto) {
        return loginBiz.operation(requestDto);
    }

    @Override
    public Result<RegisterResponseDto> register(RegisterRequestDto requestDto) {
        return registerBiz.operation(requestDto);
    }
}
