package org.ligson.se.dao.impl;

import org.ligson.fw.dao.impl.BaseDaoImpl;
import org.ligson.se.dao.UserDao;
import org.ligson.se.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ligson on 2016/1/28.
 * userDao
 */
@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {
}
