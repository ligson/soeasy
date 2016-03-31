package org.ligson.se.api;


import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.se.api.dto.LoginRequestDto;
import org.ligson.se.api.dto.LoginResponseDto;
import org.ligson.se.api.dto.RegisterRequestDto;
import org.ligson.se.api.dto.RegisterResponseDto;

/**
 * Created by ligson on 2016/3/24.
 *
 * @author ligson
 */
public interface UserApi {


    Result<LoginResponseDto> login(LoginRequestDto requestDto);

    Result<RegisterResponseDto> register(RegisterRequestDto requestDto);
}
