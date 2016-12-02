package ${servicePackage}.impl;

import ${daoPackage}.${daoName};
import ${entityPackage}.${entityName};
import ${servicePackage}.${serviceName};
import org.ligson.fw.core.dao.BaseDao;
import org.ligson.fw.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ${((tableInfo.remark)?length>0)?string(tableInfo.remark,tableInfo.tableName)}服务实现
 */
@Component
public class ${serviceName}Impl extends BaseServiceImpl<${entityName}> implements ${serviceName} {
    @Autowired
    private ${daoName} ${daoName?substring(0,1)?lower_case}${daoName?substring(1)};

    @Override
    public BaseDao<${entityName}> getDao() {
        return ${daoName?substring(0,1)?lower_case}${daoName?substring(1)};
    }
}
