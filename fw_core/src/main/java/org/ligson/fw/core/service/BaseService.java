package org.ligson.fw.core.service;


import org.ligson.fw.core.entity.BasicEntity;
import org.ligson.fw.core.entity.Pagination;


/**
 * Created by ligson on 2016/3/21.
 * 通用接口代码
 */
public interface BaseService<T extends BasicEntity> {

    T get(Object primaryKey);

    Pagination<T> findAllBy(T t);

    T findBy(T t);

    int countBy(T t);

    void delete(T t);

    void update(T t);

    void add(T t);
}
