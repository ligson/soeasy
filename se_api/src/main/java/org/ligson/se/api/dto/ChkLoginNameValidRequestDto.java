package org.ligson.se.api.dto;

import org.ligson.fw.core.facade.annotation.Param;
import org.ligson.fw.core.facade.base.dto.BaseRequestDto;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;

/**
 * Created by ligson on 2016/4/7.
 * 登录名检查
 */
public class ChkLoginNameValidRequestDto extends BaseRequestDto {
    @Param(name = "登陆名", required = true)
    private String loginName;
    @Param(name = "登陆名类型", required = true)
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
