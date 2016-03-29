package org.ligson.se.api.dto;

import org.ligson.fw.facade.base.dto.BaseResponseDto;
import org.ligson.se.api.vo.User;

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
