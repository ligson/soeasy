package ${daoPackage}.impl;

import ${daoPackage}.${daoName};
import ${entityPackage}.${entityName};
import org.ligson.fw.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * ${((tableInfo.remark)?length>0)?string(tableInfo.remark,tableInfo.tableName)}数据层实现
 */
@Repository
public class ${daoName}Impl extends BaseDaoImpl<${entityName}> implements ${daoName} {
}
