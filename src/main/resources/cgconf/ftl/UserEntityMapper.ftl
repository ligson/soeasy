<#function convert2JavaName column_name>
    <#if column_name?index_of("_")!=-1>
        <#assign cols=column_name?split("_")>
        <#assign returnValue="">
        <#list cols as col>
            <#if col_index==0>
                <#assign returnValue=col>
            <#else>
                <#assign upperChar=col?substring(0,1)?upper_case>
                <#assign rightValue=upperChar+col?substring(1)>
                <#assign returnValue=(returnValue+rightValue)>
            </#if>
        </#list>
        <#return returnValue>
    <#else>
        <#return column_name>
    </#if>
</#function>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!-- 功能模块:  -->
<mapper namespace="${entityName}Mapper">

    <!--通用表字段列表-->
    <resultMap id="BaseResultMap"
               type="${entityPackage}.${entityName}">
    <#list tableInfo.columnInfos as columInfo>
        <result column="${columInfo.name}" property="${convert2JavaName(columInfo.name)}" jdbcType="${columInfo.type}"/>
    </#list>
    </resultMap>
    <!--通用表字段列表-->

    <!--user customize code start-->

    <!--user customize code end  -->

    <!--通用查询条件组装-->
    <sql id="whereContation">
    <#list tableInfo.columnInfos as columInfo>
        <if test="${convert2JavaName(columInfo.name)} != null">
            AND ${tableInfo.primaryKeyName}=#\{${convert2JavaName(columInfo.name)},jdbcType=${columInfo.type}}
        </if>
    </#list>
    </sql>

    <!--查询字段列表拼装-->
    <sql id="baseColumnList">
    <#list tableInfo.columnInfos as columInfo>
    ${columInfo.name}<#if columInfo_index!=(tableInfo.columnInfos?size-1)>,</#if>
    </#list>
    </sql>

    <!--
    方法名称: insert
    调用路径: ${entityName}Mapper.insert
    开发信息:
    处理信息: 保存记录
    -->
    <insert id="insert"
            parameterType="com.sankai.user.entity.PersonalYunEntity">
        INSERT INTO ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list tableInfos.columnInfos as columnInfo>
            <if test="${convert2JavaName(columnInfo.name)} != null">
            ${columnInfo.name},
            </if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list tableInfos.columnInfos as columnInfo>
            <if test="${convert2JavaName(columnInfo.name)} != null">
                #\{${convert2JavaName(columnInfo.name)},jdbcType=${columnInfo.type}},
            </if>
        </#list>
        </trim>
    </insert>

    <!--
    方法名称: update
    调用路径: ${entityName}Mapper.update
    开发信息:
    处理信息: 修改记录
    -->
    <update id="update"
            parameterType="${entityPackage}.${entityName}">
        UPDATE ${table_name}
        <set>
        <#list tableInfos.columnInfos as columnInfo>
            <if test="${convert2JavaName(columnInfo.name)} != null">
            ${columnInfo.name} = #\{${convert2JavaName(columnInfo.name)},jdbcType=${columnInfo.type}},
            </if>
        </#list>
        </set>
        WHERE
    ${tableInfo.primaryKeyName} = #\{${tableInfo.primaryKeyName},jdbcType=${tableInfo.primaryKeyType}}
    </update>

    <!--
    方法名称: updateBak
    调用路径: ${entityName}Mapper.updateBak
    开发信息:
    处理信息: 修改记录
    -->
    <update id="updateBak"
            parameterType="${entityPackage}.${entityName}">
        UPDATE ${tableInfo.tableName}
        <set>
        <#list tableInfos.columnInfos as columnInfo>
        ${columnInfo.name} = #\{${convert2JavaName(columnInfo.name)},jdbcType=${columnInfo.type}},
        </#list>
        </set>
        WHERE
    ${tableInfo.primaryKeyName} = #\{${tableInfo.primaryKeyName},jdbcType=${tableInfo.primaryKeyType}}
    </update>

    <!--
    方法名称: deleteByPriKey
    调用路径:${entityName}Mapper.deleteByPriKey
    开发信息:
    处理信息: 删除记录
    -->
    <delete id="deleteByPriKey"
            parameterType="${entityPackage}.${entityName}">
        DELETE FROM ${tableInfo.tableName}
        WHERE
    ${tableInfo.primaryKeyName} = #\{${tableInfo.primaryKeyName},jdbcType=${tableInfo.primaryKeyType}}
    </delete>

    <!--
    方法名称: findByPriKey
    调用路径: ${entityName}Mapper.findByPriKey
    开发信息:
    处理信息: 根据主键查询记录
    -->
    <select id="findByPriKey"
            parameterType="${entityPackage}.${entityName}"
            resultType="${entityPackage}.${entityName}">
        SELECT
        <include refid="baseColumnList"/>
        FROM ${tableInfo.tableName}
        WHERE
    ${tableInfo.primaryKeyName} = #\{${tableInfo.primaryKeyName},jdbcType=${tableInfo.primaryKeyType}}
    </select>

    <!--
    方法名称: getPagenationList
    调用路径: ${entityName}Mapper.getPagenationList
    开发信息:
    处理信息: 分页查询记录
    -->
    <select id="getPagenationList"
            parameterType="${entityPackage}.${entityName}"
            resultType="${entityPackage}.${entityName}">
        <!-- 分页条 -->
        <include refid="CommonEntity.paginationPrefix"/>
        SELECT
        <include refid="baseColumnList"/>
        FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereContation"/>
        <if test="columnSort != null">
            ORDER BY ${columnSort}
        </if>
        <!-- 分页条 -->
        <include refid="CommonEntity.paginationSuffix"/>
    </select>

    <!--
    方法名称: getPagenationList-count
    调用路径: ${entityName}Mapper.getPagenationList-count
    开发信息:
    处理信息: 查询记录数
    -->
    <select id="getPagenationList-count"
            parameterType="${entityPackage}.${entityName}"
            resultType="int">
        SELECT count(1) FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereContation"/>
    </select>

    <!--
    方法名称: getList
    调用路径: ${entityName}Mapper.getList
    开发信息:
    处理信息: 根据条件查询记录
    -->
    <select id="getList"
            parameterType="${entityPackage}.${entityName}"
            resultType="${entityPackage}.${entityName}">
        SELECT
        <include refid="baseColumnList"/>
        FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereContation"/>
        <if test="columnSort != null">
            ORDER BY ${columnSort}
        </if>
        limit 0,100
    </select>
</mapper>