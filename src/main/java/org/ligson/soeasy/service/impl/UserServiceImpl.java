package org.ligson.soeasy.service.impl;

import org.ligson.fw.dao.BaseDao;
import org.ligson.fw.service.impl.BaseServiceImpl;
import org.ligson.soeasy.dao.impl.UserDaoImpl;
import org.ligson.soeasy.entity.UserEntity;
import org.ligson.soeasy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/1/28.
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {
    @Resource
    private UserDaoImpl userDao;

    @Override
    public BaseDao<UserEntity> getDao() {
        return userDao;
    }
}
