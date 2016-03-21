package org.ligson.soeasy.biz.core.base.service.impl;


import org.ligson.soeasy.biz.core.base.dao.ISuperDAO;
import org.ligson.soeasy.biz.core.base.entity.BasicEntity;
import org.ligson.soeasy.biz.core.base.entity.Pagination;
import org.ligson.soeasy.biz.core.base.service.BaseService;
import org.ligson.soeasy.utils.IdUtils;

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
    @SuppressWarnings(value = "unchecked")
    public Pagination<T> findAllBy(T o) {
        return getDao().getPagenationList(o);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public int countBy(T t) {
        return getDao().countBy(t);
    }

    @Override
    public void delete(T t) {
        getDao().delete(t);
    }

    @Override
    public void update(T t) {
        getDao().update(t);
    }

    @Override
    public void add(T t) {
        if (t.getId() == null) {
            t.setId(IdUtils.randomId());
        }
        getDao().insert(t);
    }
}
