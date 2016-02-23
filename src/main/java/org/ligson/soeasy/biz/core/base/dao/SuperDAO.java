package org.ligson.soeasy.biz.core.base.dao;


import org.ligson.soeasy.biz.core.base.entity.BasePageDTO;
import org.ligson.soeasy.biz.core.base.entity.BasicEntity;
import org.ligson.soeasy.biz.core.base.entity.Pagination;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public class SuperDAO<E extends BasicEntity> implements ISuperDAO<E> {

    public static final Logger log = LoggerFactory.getLogger(SuperDAO.class);

    private static final String pagenationStatementSuffix = "Mapper.getPagenationList";
    private static final String pagenationCountStatementSuffix = "-count";
    private static final String getListStatementSuffix = "Mapper.getList";
    private static final String selectStatementSuffix = "Mapper.findBy";
    private static final String insertStatementSuffix = "Mapper.insert";
    private static final String updateStatementSuffix = "Mapper.update";
    private static final String deleteStatementSuffix = "Mapper.delete";
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
                updateStatementSuffix;
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
                deleteStatementSuffix;
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
                insertStatementSuffix;
        return userSqlSessionTemplate.insert(statementName, e);
    }

    /***
     * 根据条件查询一条记录
     *
     * @param e 查询条件
     * @return 查询的实体
     */
    @Override
    public E get(E e) {
        String statementName = e.getClass().getSimpleName() +
                selectStatementSuffix;
        return userSqlSessionTemplate.selectOne(statementName, e);
    }

    /***
     * 返回所有结果
     *
     * @param e 查询条件
     * @return 返回所有结果
     */
    @Override
    public List<E> getList(E e) {
        String statementName = e.getClass().getSimpleName() + getListStatementSuffix;
        return userSqlSessionTemplate.selectList(statementName, e);
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

    /*
    *
    * desc:
    * (non-Javadoc)
    * @see com.wangyin.payment.tesla.dao.ISuperDAO#getPagenationList(java.lang.String, com.wangyin.wallet.common.dto.BasePageDTO)
    */
    @Override
    public Pagination getPagenationList(BasePageDTO baseParamDTO) {
        /**
         * 判断pageNum和pageSize
         */
        if (baseParamDTO.getPageNum() == null || baseParamDTO.getPageNum().intValue() < 1) {
            baseParamDTO.setPageNum(1);
        }
        if (baseParamDTO.getMax() == null || baseParamDTO.getMax().intValue
                () <
                1) {
            baseParamDTO.setMax(10);
        }

        String statementName = baseParamDTO.getClass().getSimpleName();
        // 计算记录起始值和结束值
        Integer totalCount = (Integer) userSqlSessionTemplate.selectOne(statementName + pagenationCountStatementSuffix, baseParamDTO);

        List resultList = userSqlSessionTemplate.selectList(statementName, baseParamDTO);

        return new Pagination(baseParamDTO.getMax(), baseParamDTO.getPageNum(),
                totalCount, resultList);
    }

}

