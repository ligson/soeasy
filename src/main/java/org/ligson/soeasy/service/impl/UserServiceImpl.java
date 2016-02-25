package org.ligson.soeasy.service.impl;

import org.ligson.soeasy.dao.UserDao;
import org.ligson.soeasy.entity.UserEntity;
import org.ligson.soeasy.service.UserService;
import org.ligson.soeasy.utils.IdUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ligson on 2016/1/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserEntity register(UserEntity userEntity) {
        userEntity.setId(IdUtils.randomId());
        userDao.insert(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> find(UserEntity userEntity) {
        return userDao.getList(userEntity);
    }

    @Override
    public int update(UserEntity userEntity) {
        return userDao.update(userEntity);
    }

    @Override
    public void remove(UserEntity userEntity) {
        userDao.delete(userEntity);
    }
}
