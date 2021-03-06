package org.ligson.se.api.dto;

import org.ligson.fw.core.facade.base.dto.BaseRequestDto;
import org.ligson.fw.core.facade.annotation.Param;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;

/**
 * Created by ligson on 2016/3/24.
 * 登录请求
 */
public class LoginRequestDto extends BaseRequestDto {

    @Param(name = "登陆名", required = true)
    private String loginName;
    @Param(name = "登陆名类型", required = true)
    private LoginNameTypeEnum loginNameTypeEnum;
    @Param(name = "密码", required = true)
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LoginNameTypeEnum getLoginNameTypeEnum() {
        return loginNameTypeEnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginNameTypeEnum(LoginNameTypeEnum loginNameTypeEnum) {
        this.loginNameTypeEnum = loginNameTypeEnum;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "loginName='" + loginName + '\'' +
                ", loginNameTypeEnum=" + loginNameTypeEnum +
                ", password='" + password + '\'' +
                '}';
    }
}
