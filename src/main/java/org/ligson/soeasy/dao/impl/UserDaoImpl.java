package org.ligson.soeasy.dao.impl;

import org.ligson.fw.dao.impl.BaseDaoImpl;
import org.ligson.soeasy.dao.UserDao;
import org.ligson.soeasy.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ligson on 2016/1/28.
 * userDao
 */
@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {
}
