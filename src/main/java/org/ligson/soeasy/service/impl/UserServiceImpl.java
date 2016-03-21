package org.ligson.soeasy.service.impl;

import org.ligson.soeasy.biz.core.base.dao.ISuperDAO;
import org.ligson.soeasy.biz.core.base.entity.Pagination;
import org.ligson.soeasy.biz.core.base.service.impl.BaseServiceImpl;
import org.ligson.soeasy.dao.UserDao;
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
    private UserDao userDao;

    @Override
    public ISuperDAO<UserEntity> getDao() {
        return userDao;
    }
}
