package org.ligson.fw.dao.impl;


import org.ligson.fw.dao.BaseDao;
import org.ligson.fw.entity.BasePageDto;
import org.ligson.fw.entity.BasicEntity;
import org.ligson.fw.entity.Pagination;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


@Repository
public class BaseDaoImpl<E extends BasicEntity> implements BaseDao<E> {

    public static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

    private static final String pageSuffix = "Mapper.getPaginationList";
    private static final String pageCountSuffix = "-count";
    private static final String getListSuffix = "Mapper.getList";
    private static final String findBySuffix = "Mapper.findBy";
    private static final String insertSuffix = "Mapper.insert";
    private static final String updateSuffix = "Mapper.update";
    private static final String deleteSuffix = "Mapper.delete";
    private static final String batchUpdateSuffix = "Mapper.batchUpdate";
    private static final String batchInsertSuffix = "Mapper.batchInsert";

    /**
     * 批量sql单次执行的数量
     */
    private static final int batchExecuteOnceCount = 300;
    /**
     * 运行环境的SessionTemplate
     */
    @Autowired
    protected SqlSessionTemplate userSqlSessionTemplate;

    /***
     * 更新方法
     *
     * @param e 实体,主键不能为空
     * @return 更新的记录数
     */
    @Override
    public Integer update(E e) {
        String statementName = e.getClass().getSimpleName() +
                updateSuffix;
        return userSqlSessionTemplate.update(statementName, e);
    }

    /***
     * 删除记录
     *
     * @param e 实体条件
     * @return 删除的记录数
     */
    @Override
    public Integer delete(E e) {
        String statementName = e.getClass().getSimpleName() +
                deleteSuffix;
        return userSqlSessionTemplate.update(statementName, e);
    }

    /***
     * 插入记录
     *
     * @param e 实体
     * @return 操作记录
     */
    @Override
    public Integer insert(E e) {
        String statementName = e.getClass().getSimpleName() +
                insertSuffix;
        return userSqlSessionTemplate.insert(statementName, e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(Object id) {
        try {
            Class clazz = getGenericType(0);
            Object object = clazz.newInstance();
            Method reflectKeyMethod = clazz.getMethod("primaryKey");
            Method reflectKeyTypeMethod = clazz.getMethod("primaryKeyType");
            String primaryKey = reflectKeyMethod.invoke(object).toString();
            String keyName = primaryKey.substring(0, 1).toUpperCase() + primaryKey.substring(1);
            Class keyType = (Class) reflectKeyTypeMethod.invoke(object);
            Method method = clazz.getDeclaredMethod("set" + keyName, keyType);
            method.invoke(object, id);
            return findBy((E) object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 根据条件查询一条记录
     *
     * @param e 查询条件
     * @return 查询的实体
     */
    @Override
    public E findBy(E e) {
        String statementName = e.getClass().getSimpleName() +
                findBySuffix;
        return userSqlSessionTemplate.selectOne(statementName, e);
    }

    /***
     * 返回所有结果
     *
     * @param e 查询条件
     * @return 返回所有结果
     */
    @Override
    public List<E> findAllBy(E e) {
        String statementName = e.getClass().getSimpleName() + getListSuffix;
        return userSqlSessionTemplate.selectList(statementName, e);
    }

    @Override
    public Integer countBy(E entity) {
        return userSqlSessionTemplate.selectOne(entity.getClass().getSimpleName() + "Mapper.countBy", entity);
    }

    /***
     * 批量插入记录
     *
     * @param basicEntityList 列表
     * @return 插入成功的记录数
     */
    @Override
    public int batchInsert(List<E> basicEntityList) {
        //每次I/O提交数量
        int singleNum = batchExecuteOnceCount;
        //sql执行影响数据行数
        int affectedRows = 0;
        try {
            if (basicEntityList != null && basicEntityList.size() > 0) {
                String statementName = basicEntityList.get(0).getClass().getSimpleName();
                statementName = statementName + batchInsertSuffix;
                int rowSize = basicEntityList.size();//数据总量
                int fromIndex = 0;//起始序号
                int endIndex = 0;//结束序号
                log.debug("批量执行插入【" + statementName + "】开始：" + System.currentTimeMillis());
                for (int i = 0; i == 0 || i < Math.ceil((double) (rowSize / singleNum)); i++) {
                    endIndex = (i + 1) * singleNum;//默认结束序号滚动一页
                    if (endIndex >= rowSize) {//如结束序号大于等于数据总量时，把数据总量赋值给结束序列
                        endIndex = rowSize;
                    }
                    log.debug("批量执行插入【" + statementName + "】第【" + (i + 1) + "】次共【" + (endIndex - fromIndex) + "】条记录开始：" + System.currentTimeMillis());
                    affectedRows += userSqlSessionTemplate.insert(statementName, basicEntityList.subList(fromIndex, endIndex));
                    log.debug("批量执行插入【" + statementName + "】第【" + (i + 1) + "】次共【" + (endIndex - fromIndex) + "】条记录结束：" + System.currentTimeMillis());
                    fromIndex = endIndex;
                }
                log.debug("批量执行插入【" + statementName + "】结束：" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            log.error("系统批量插入数据出错：", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    /***
     * 批量更新记录
     *
     * @param basicEntityList 批量更新记录
     * @return 批量更新记录
     */
    @Override
    public int batchUpdate(List<E> basicEntityList) {
        //每次I/O提交数量
        int singleNum = batchExecuteOnceCount;
        //sql执行影响数据行数
        int affectedRows = 0;
        try {
            if (basicEntityList != null && basicEntityList.size() > 0) {
                String statementName = basicEntityList.get(0).getClass().getSimpleName();
                statementName = statementName + batchUpdateSuffix;
                int rowSize = basicEntityList.size();//数据总量
                int fromIndex = 0;//起始序号
                int endIndex = 0;//结束序号
                log.debug("批量执行更新【" + statementName + "】开始：" + System.currentTimeMillis());
                for (int i = 0; i == 0 || i < Math.ceil(Double.valueOf(Integer.valueOf(rowSize / singleNum))); i++) {
                    endIndex = (i + 1) * singleNum;//默认结束序号滚动一页
                    if (endIndex >= rowSize) {//如结束序号大于等于数据总量时，把数据总量赋值给结束序列
                        endIndex = rowSize;
                    }
                    log.debug("批量执行更新【" + statementName + "】第【" + (i + 1) + "】次共【" + (endIndex - fromIndex) + "】条记录开始：" + System.currentTimeMillis());
                    affectedRows += userSqlSessionTemplate.update(statementName, basicEntityList.subList(fromIndex, endIndex));
                    log.debug("批量执行更新【" + statementName + "】第【" + (i + 1) + "】次共【" + (endIndex - fromIndex) + "】条记录结束：" + System.currentTimeMillis());
                    fromIndex = endIndex;
                }
                log.debug("批量执行更新【" + statementName + "】结束：" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            log.error("系统批量更新数据出错：", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    /*
    *
    * desc:
    * (non-Javadoc)
    */
    @Override
    public Pagination<E> getPaginationList(E e) {
        BasePageDto basePageDto = null;
        if (e != null) {
            basePageDto = e;
        }
        if (basePageDto == null) {
            return null;
        }
        /**
         * 判断pageNum和pageSize
         */
        if (basePageDto.getPageNum() == null || basePageDto.getPageNum() < 1) {
            basePageDto.setPageNum(1);
        }
        if (basePageDto.getMax() == null || basePageDto.getMax() <
                1) {
            basePageDto.setMax(10);
        }

        String clzName = basePageDto.getClass().getSimpleName();
        String countStatementName = clzName + pageSuffix +
                pageCountSuffix;
        String statementName = clzName + pageSuffix;
        // 计算记录起始值和结束值
        Integer totalCount = userSqlSessionTemplate.selectOne
                (countStatementName, basePageDto);
        log.debug(statementName);
        List<E> resultList = userSqlSessionTemplate.selectList(statementName, basePageDto);

        return new Pagination<>(basePageDto.getMax(), basePageDto.getPageNum(),
                totalCount, resultList);
    }

    @SuppressWarnings("rawtypes")
    private Class getGenericType(int index) {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

}

