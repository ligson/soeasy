package org.ligson.soeasy.biz.core.base.service;

import org.ligson.soeasy.biz.core.base.entity.BasicEntity;
import org.ligson.soeasy.biz.core.base.entity.Pagination;

import java.math.BigInteger;

/**
 * Created by ligson on 2016/3/21.
 * 通用接口代码
 */
public interface BaseService<T extends BasicEntity> {
    public T get(BigInteger id);

    public Pagination<T> findAllBy(T t);

    public int countBy(T t);

    public void delete(T t);

    public void update(T t);
}
