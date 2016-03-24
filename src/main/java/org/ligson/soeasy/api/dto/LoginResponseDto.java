package org.ligson.soeasy.api.dto;

import org.ligson.fw.facade.base.dto.BaseResponseDto;

/**
 * Created by ligson on 2016/3/24.
 * 登录响应
 */
public class LoginResponseDto extends BaseResponseDto {
    private Boolean success;

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
