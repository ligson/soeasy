package com.eling.callcenter.dao.impl;

import com.eling.callcenter.dao.CallLogDao;
import com.eling.callcenter.entity.CallLogEntity;
import org.ligson.fw.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * call_log数据层实现
 */
@Repository
public class CallLogDaoImpl extends BaseDaoImpl<CallLogEntity> implements CallLogDao {
}
