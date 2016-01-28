package org.ligson.soeasy.biz.core.base.dao;


import org.apache.ibatis.session.RowBounds;
import org.ligson.soeasy.biz.core.base.entity.BasicEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class SuperDAO<E extends BasicEntity> implements ISuperDAO<E> {

    public static final Logger log = LoggerFactory.getLogger(SuperDAO.class);

    private static final String pagenationStatementSuffix = "Mapper.getPagenationList";
    private static final String pagenationCountStatementSuffix = "-count";
    private static final String getListStatementSuffix = "Mapper.getList";
    private static final String selectStatementSuffix = "Mapper.findByPriKey";
    private static final String insertStatementSuffix = "Mapper.insert";
    private static final String updateStatementSuffix = "Mapper.update";
    private static final String deleteStatementSuffix = "Mapper.deleteByPriKey";
    private static final String getNextIdValStatement = "CommonEntity.getNextIdVal";
    private static final String batchUpdateStatementSuffix = "Mapper.batchUpdate";
    private static final String batchInsertStatementSuffix = "Mapper.batchInsert";

    /**
     * 批量sql单次执行的数量
     */
    private static final int batchExecuteOnceCount = 300;
    /**
     * 运行环境的SessionTemplate
     */
    @Autowired
    private SqlSessionTemplate userSqlSessionTemplate;

    /*
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.dao.ISuperDAO#update(java.lang.Object)
     */
    @Override
    public Integer update(E e) {
        //String statementName = parameterObject.getClass().getSimpleName() + updateStatementSuffix;
        //return this.update(statementName, parameterObject);
        return null;
    }

    /*
     * 
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.dao.ISuperDAO#delete(java.lang.Object)
     */
    @Override
    public Integer delete(E e) {
        //String statementName = parameterObject.getClass().getSimpleName() + deleteStatementSuffix;
        //return this.delete(statementName, parameterObject);
        return null;
    }


    /*
     * 
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.dao.ISuperDAO#insert(com.wangyin.wallet.common.BasicEntity)
     */
    @Override
    public Integer insert(E e) {
        //String statementName = parameterObject.getClass().getSimpleName() + insertStatementSuffix;
        //return userSqlSessionTemplate.insert(statementName, parameterObject);
        return null;
    }

    /*
     * 
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.dao.ISuperDAO#get(java.lang.Object)
     */
    @Override
    public E get(E e) {
        //String statementName = parameterObject.getClass().getSimpleName() + selectStatementSuffix;
        //return userSqlSessionTemplate.selectOne(statementName, parameterObject);
        return null;
    }


    /*
     *
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.dao.ISuperDAO#getList(java.lang.Object)
     */
    @Override
    public List<E> getList(E e) throws DataAccessException {
        // String statementName = parameterObject.getClass().getSimpleName() + getListStatementSuffix;
        //return userSqlSessionTemplate.selectList(statementName, parameterObject);
        return null;
    }


    /* 
     * desc:
	 * (non-Javadoc)
	 * @see com.wangyin.payment.tesla.common.dao.ISuperDAO#batchInsert(java.util.List)
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
                statementName = statementName + batchInsertStatementSuffix;
                int rowSize = basicEntityList.size();//数据总量
                int fromIndex = 0;//起始序号
                int endIndex = 0;//结束序号
                log.debug("批量执行插入【" + statementName + "】开始：" + System.currentTimeMillis());
                for (int i = 0; i == 0 || i < Math.ceil(Double.valueOf(Integer.valueOf(rowSize / singleNum))); i++) {
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

    /*
     * desc:
     * (non-Javadoc)
     * @see com.wangyin.payment.tesla.common.dao.ISuperDAO#batchUpdate(java.util.List)
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
                statementName = statementName + batchUpdateStatementSuffix;
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

    @Override
    public E findById(BigInteger id) {
        E entity = userSqlSessionTemplate.selectOne(getStatementName() + selectStatementSuffix, id);
        return entity;
    }

    private String getStatementName() {
        return this.getClass().getSimpleName();
    }


}
