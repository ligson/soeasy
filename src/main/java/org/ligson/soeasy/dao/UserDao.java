package org.ligson.soeasy.dao;

import org.ligson.soeasy.biz.core.base.dao.SuperDAO;
import org.ligson.soeasy.entity.UserEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ligson on 2016/1/28.
 */
@Repository
public class UserDao extends SuperDAO<UserEntity> {
}
