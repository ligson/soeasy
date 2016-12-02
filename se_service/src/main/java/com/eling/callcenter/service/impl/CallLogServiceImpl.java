package com.eling.callcenter.service.impl;

import com.eling.callcenter.dao.CallLogDao;
import com.eling.callcenter.entity.CallLogEntity;
import com.eling.callcenter.service.CallLogService;
import org.ligson.fw.core.dao.BaseDao;
import org.ligson.fw.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * call_log服务实现
 */
@Component
public class CallLogServiceImpl extends BaseServiceImpl<CallLogEntity> implements CallLogService {
    @Autowired
    private CallLogDao callLogDao;

    @Override
    public BaseDao<CallLogEntity> getDao() {
        return callLogDao;
    }
}
