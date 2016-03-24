package org.ligson.soeasy.facade;

import org.ligson.fw.facade.base.result.Result;
import org.ligson.soeasy.api.UserApi;
import org.ligson.soeasy.api.dto.LoginRequestDto;
import org.ligson.soeasy.api.dto.LoginResponseDto;

/**
 * Created by ligson on 2016/3/24.
 * 对外api实现
 */
public class UserApiImpl implements UserApi {

    @Override
    public Result<LoginResponseDto> login(LoginRequestDto requestDto) {
        return null;
    }
}
