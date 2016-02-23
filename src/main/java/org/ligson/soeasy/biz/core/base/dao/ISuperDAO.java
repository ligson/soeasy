package org.ligson.soeasy.biz.core.base.dao;

import org.apache.ibatis.session.RowBounds;
import org.ligson.soeasy.biz.core.base.entity.BasicEntity;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 * 描述: 通用数据库操作DAO接口类，该类实现了常用的数据库操作
 *
 * @version V1.0
 */
@SuppressWarnings("rawtypes")
public interface ISuperDAO<E extends BasicEntity> {

    /**
     * 描述: 系统默认更新实体信息
     *
     * @param entity 需要更新的实体信息
     * @return
     */
    public Integer update(E entity);

    /**
     * 描述: 系统默认删除满足条件的实体信息
     *
     * @param entity 需要删除的实体条件信息
     * @return
     */
    public Integer delete(E entity);

    /**
     * 描述: 系统默认插入实体信息
     *
     * @param entity 需要插入的实体信息
     * @return
     */
    public Integer insert(E entity);

    /**
     * 描述: 系统默认根据主键查询唯一记录
     *
     * @param entity 实体参数查询条件（需包含主键信息）
     * @return
     */
    public E get(E entity);

    /**
     * 描述: 系统默认根据实体参数查询满足条件的记录
     *
     * @param entity 实体参数查询条件
     * @return
     */
    public List<E> getList(E entity);


    /**
     * 描述: 批量插入实体信息
     *
     * @param entityList 需要批量插入的实体信息
     * @return
     */
    public int batchInsert(List<E> entityList);

    /**
     * 描述: 批量更新实体信息
     *
     * @param entityList 需要批量更新的实体信息
     * @return
     */
    public int batchUpdate(List<E> entityList);

    public E findById(BigInteger bigInteger);

}