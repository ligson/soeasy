package ${entityPackage};

import org.ligson.soeasy.biz.core.base.entity.BasicEntity;

import java.io.Serializable;
<#list tableInfo.columnInfos as columnInfo>
<#if !columnInfo.javaType.name?starts_with("java.lang")>
import ${columnInfo.javaType.name};
</#if>
</#list>

public class ${entityName} extends BasicEntity implements Serializable {
<#list tableInfo.columnInfos as columnInfo>

${"    "}/***
${"     "}* ${((columnInfo.remark)?length>0)?string(columnInfo.remark,columnInfo.javaName)}
${"     "}*/
${"    "}private ${columnInfo.javaType.simpleName} ${columnInfo.javaName};
</#list>

<#list tableInfo.columnInfos as columnInfo>
    <#assign propName=columnInfo.javaName?cap_first/>

${"    "}/***
${"     "}* 获取${((columnInfo.remark)?length>0)?string(columnInfo.remark,columnInfo.javaName)}
${"     "}*
${"     "}* @return 获取${((columnInfo.remark)?length>0)?string(columnInfo.remark,columnInfo.javaName)}
${"     "}*/
${"    "}public ${columnInfo.javaType.simpleName} get${propName}() {
${"        "}return ${columnInfo.javaName};
${"    "}}

${"    "}/***
${"     "}* 设置${((columnInfo.remark)?length>0)?string(columnInfo.remark,columnInfo.javaName)}
${"     "}*
${"     "}* @param ${columnInfo.javaName} ${((columnInfo.remark)?length>0)?string(columnInfo.remark,columnInfo.javaName)}
${"     "}*/
${"    "}public void set${propName}(${columnInfo.javaType.simpleName} ${columnInfo
.javaName}) {
${"        "}this.${columnInfo.javaName} = ${columnInfo.javaName};
${"    "}}
</#list>

<#if tableInfo.primaryKey.javaName != "id">
${"    "}/***
${"     "}* 主键字段
${"     "}*
${"     "}* @return 主键名
${"     "}*/
${"    "}public String primaryKey() {
${"        "}return "${tableInfo.primaryKey.javaName}";
${"    "}}

${"    "}/***
${"     "}* 主键类型
${"     "}*
${"     "}* @return 主键类型
${"     "}*/
${"    "}public Class primaryType() {
${"        "}return ${tableInfo.primaryKey.javaType.simpleName}.class;
${"    "}}
</#if>

${"    "}@Override
${"    "}public String toString() {
${"        "}return "${entityName}{" +
<#list tableInfo.columnInfos as columnInfo>
    <#assign propName=columnInfo.javaName?cap_first/>
    <#if columnInfo_index==0>
${"                "}"${columnInfo.javaName}=" + ${columnInfo.javaName} +
    <#else>

${"                "}",${columnInfo.javaName}=" + ${columnInfo.javaName} +
    </#if>
</#list>
${"                "}'}';
${"    "}}
}
