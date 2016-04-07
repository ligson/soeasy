package org.ligson.se.api;


import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.se.api.dto.*;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;

/**
 * Created by ligson on 2016/3/24.
 *
 * @author ligson
 */
public interface UserApi {


    Result<LoginResponseDto> login(LoginRequestDto requestDto);

    Result<RegisterResponseDto> register(RegisterRequestDto requestDto);

    Result<ChkLoginNameValidResponseDto> checkLoginName(ChkLoginNameValidRequestDto requestDto);
}
