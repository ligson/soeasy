package user;

import base.DubboBaseTest;
import org.junit.Test;
import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.fw.core.utils.encode.HashHelper;
import org.ligson.se.api.dto.LoginRequestDto;
import org.ligson.se.api.dto.LoginResponseDto;
import org.ligson.se.api.dto.RegisterRequestDto;
import org.ligson.se.api.dto.RegisterResponseDto;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;

/**
 * Created by ligson on 2016/3/29.
 */
public class DubboUserApiTest extends DubboBaseTest {
    @Test
    public void reg() {
        RegisterRequestDto requestDto = new RegisterRequestDto();
        requestDto.setName("ligson");
        requestDto.setPassword(HashHelper.md5("password"));
        requestDto.setMobile("18210344122");
        Result<RegisterResponseDto> result = userApi.register(requestDto);
        testResult(result);
        println(result.getData());
    }

    @Test
    public void login() {
        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setLoginName("ligson");
        requestDto.setLoginNameTypeEnum(LoginNameTypeEnum.NAME);
        requestDto.setPassword(HashHelper.md5("password"));
        Result<LoginResponseDto> result = userApi.login(requestDto);
        testResult(result);
        println(result.getData());
        println(result.getData().getSuccess());
    }
}
