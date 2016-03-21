package org.ligson.soeasy.biz.core.base.service.impl;


import org.ligson.soeasy.biz.core.base.dao.ISuperDAO;
import org.ligson.soeasy.biz.core.base.entity.BasicEntity;
import org.ligson.soeasy.biz.core.base.entity.Pagination;
import org.ligson.soeasy.biz.core.base.service.BaseService;

import java.math.BigInteger;

/**
 * Created by ligson on 2016/3/21.
 * 接口实现
 */
public abstract class BaseServiceImpl<T extends BasicEntity> implements BaseService<T> {

    public abstract ISuperDAO<T> getDao();

    @Override
    public T get(BigInteger id) {
        return getDao().get(id);
    }

    @Override
    public Pagination<T> findAllBy(T o) {
        return null;
    }

    @Override
    public int countBy(T t) {
        return 0;
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void update(T t) {

    }
}
