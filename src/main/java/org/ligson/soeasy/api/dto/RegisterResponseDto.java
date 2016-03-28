package org.ligson.soeasy.api.dto;

import org.ligson.fw.facade.base.dto.BaseResponseDto;
import org.ligson.soeasy.api.vo.User;

/**
 * Created by ligson on 2016/3/28.
 */
public class RegisterResponseDto extends BaseResponseDto {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
