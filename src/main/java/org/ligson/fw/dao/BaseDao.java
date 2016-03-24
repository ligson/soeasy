package org.ligson.fw.dao;

import java.util.List;

import org.ligson.fw.entity.BasicEntity;
import org.ligson.fw.entity.Pagination;


/**
 * 描述: 通用数据库操作DAO接口类，该类实现了常用的数据库操作
 *
 * @version V1.0
 */
@SuppressWarnings("rawtypes")
public interface BaseDao<E extends BasicEntity> {

    /**
     * 描述: 系统默认更新实体信息
     *
     * @param entity 需要更新的实体信息
     * @return 更新的记录数
     */
    Integer update(E entity);

    /**
     * 描述: 系统默认删除满足条件的实体信息
     *
     * @param entity 需要删除的实体条件信息
     * @return 删除的记录数
     */
    Integer delete(E entity);

    /**
     * 描述: 系统默认插入实体信息
     *
     * @param entity 需要插入的实体信息
     * @return 插入的记录数
     */
    Integer insert(E entity);

    /***
     * @param primaryKey 主键
     * @return 实体对象
     */
    E get(Object primaryKey);

    /**
     * 描述: 系统默认根据主键查询唯一记录
     *
     * @param entity 实体参数查询条件（需包含主键信息）
     * @return 查询结果
     */
    E findBy(E entity);

    /**
     * 描述: 系统默认根据实体参数查询满足条件的记录
     *
     * @param entity 实体参数查询条件
     * @return 查询结果
     */
    List<E> findAllBy(E entity);

    /***
     * 按照条件统计
     *
     * @param entity 实体参数查询条件
     * @return 查询结果
     */
    Integer countBy(E entity);


    /**
     * 描述: 批量插入实体信息
     *
     * @param entityList 需要批量插入的实体信息
     * @return 插入的记录数
     */
    int batchInsert(List<E> entityList);

    /**
     * 描述: 批量更新实体信息
     *
     * @param entityList 需要批量更新的实体信息
     * @return 更新的记录数
     */
    int batchUpdate(List<E> entityList);

    /***
     * 分页查询
     *
     * @param entity 查询条件
     * @return 查询结果
     */
    Pagination<E> getPaginationList(E
                                                   entity);

}
