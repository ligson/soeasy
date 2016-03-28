package org.ligson.fw.service.impl;


import org.ligson.fw.dao.BaseDao;
import org.ligson.fw.entity.BasicEntity;
import org.ligson.fw.entity.Pagination;
import org.ligson.fw.service.BaseService;

/**
 * Created by ligson on 2016/3/21.
 * 接口实现
 */
public abstract class BaseServiceImpl<T extends BasicEntity> implements BaseService<T> {

    public abstract BaseDao<T> getDao();

    @Override
    public T get(Object primaryKey) {
        return getDao().get(primaryKey);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Pagination<T> findAllBy(T o) {
        return getDao().getPaginationList(o);
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
        getDao().insert(t);
    }

    @Override
    public T findBy(T t) {
        return getDao().findBy(t);
    }
}
