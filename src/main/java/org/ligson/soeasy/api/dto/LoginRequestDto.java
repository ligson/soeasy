package org.ligson.soeasy.api.dto;

import org.ligson.fw.facade.base.dto.BaseRequestDto;
import org.ligson.soeasy.api.enums.user.LoginNameTypeEnum;

/**
 * Created by ligson on 2016/3/24.
 * 登录请求
 */
public class LoginRequestDto extends BaseRequestDto {
    private String loginName;
    private LoginNameTypeEnum loginNameTypeEnum;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LoginNameTypeEnum getLoginNameTypeEnum() {
        return loginNameTypeEnum;
    }

    public void setLoginNameTypeEnum(LoginNameTypeEnum loginNameTypeEnum) {
        this.loginNameTypeEnum = loginNameTypeEnum;
    }
}
