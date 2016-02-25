package org.ligson.soeasy.service;

import org.ligson.soeasy.entity.UserEntity;

import java.util.List;

/**
 * Created by ligson on 2016/1/28.
 */
public interface UserService {
    public UserEntity register(UserEntity userEntity);

    public List<UserEntity> find(UserEntity userEntity);

    public int update(UserEntity userEntity);

    public void remove(UserEntity userEntity);
}
