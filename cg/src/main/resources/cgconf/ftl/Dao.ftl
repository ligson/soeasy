package ${daoPackage};

import org.ligson.fw.core.dao.BaseDao;
import ${entityPackage}.${entityName};

/**
 * ${((tableInfo.remark)?length>0)?string(tableInfo.remark,tableInfo.tableName)}数据层
 */
public interface ${daoName} extends BaseDao<${entityName}> {
}
