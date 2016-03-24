package org.ligson.soeasy.api;

import org.ligson.fw.facade.base.result.Result;
import org.ligson.soeasy.api.dto.LoginRequestDto;
import org.ligson.soeasy.api.dto.LoginResponseDto;

/**
 * Created by ligson on 2016/3/24.
 *
 * @author ligson
 */
public interface UserApi {

    Result<LoginResponseDto> login(LoginRequestDto requestDto);
}
