package ${entityPackage};

import org.ligson.soeasy.biz.core.base.entity.BasicEntity;

import java.io.Serializable;
<#list tableInfo.columnInfos as columnInfo>
import ${columnInfo.javaType.name};
</#list>

public class ${entityName} extends BasicEntity implements Serializable {
    <#list tableInfo.columnInfos as columnInfo>
    /***
     * ${columnInfo.remark}
     */
    private ${columnInfo.javaType.simpleName} ${columnInfo.javaName};
    </#list>

    <#list tableInfo.columnInfos as columnInfo>
    <#assign propName=columnInfo.javaName?cap_first/>

    public ${columnInfo.javaType.simpleName} get${propName}() {
        return ${columnInfo.javaName};
    }

    public void set${propName}(BigInteger ${columnInfo.javaName}) {
        this.${columnInfo.javaName} = ${columnInfo.javaName};
    }
    </#list>

    @Override
    public String toString() {
        return "${entityName}{" +
        <#list tableInfo.columnInfos as columnInfo>
            <#if columnInfo_index==0>
                "${columnInfo.javaName}=" + ${columnInfo.javaName} +
            <#else>
                ",${columnInfo.javaName}=" + ${columnInfo.javaName} +
            </#if>
        </#list>
                '}';
    }
}
