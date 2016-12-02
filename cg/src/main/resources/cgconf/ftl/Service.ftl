package ${servicePackage};

import org.ligson.fw.core.service.BaseService;
import ${entityPackage}.${entityName};

/**
* ${((tableInfo.remark)?length>0)?string(tableInfo.remark,tableInfo.tableName)}服务
*/
public interface ${serviceName} extends BaseService<${entityName}> {
}
