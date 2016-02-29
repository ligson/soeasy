<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE ${"mapper"} PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!-- 功能模块:  -->
<mapper namespace="${entityName}Mapper">

    <!--通用表字段列表-->
    <resultMap id="BaseResultMap"
               type="${entityPackage}.${entityName}">
    <#list tableInfo.columnInfos as columnInfo>
        <result column="${columnInfo.name}" property="${columnInfo.javaName}" jdbcType="${columnInfo.type}"/>
    </#list>
    </resultMap>
    <!--通用表字段列表-->

    <!--通用查询条件组装-->
    <sql id="whereCondition">
    <#list tableInfo.columnInfos as columnInfo>
        <if test="${columnInfo.javaName} != null">
            AND ${columnInfo.name}=${"#"}{${columnInfo.javaName},jdbcType=${columnInfo.type}}
        </if>
    </#list>
    </sql>

    <!--查询字段列表拼装-->
    <sql id="baseColumnList">
    <#list tableInfo.columnInfos as columnInfo>
    ${columnInfo.name}<#if columnInfo_index!=(tableInfo.columnInfos?size-1)>,</#if>
    </#list>
    </sql>

    <!--
    方法名称: insert
    调用路径: ${entityName}Mapper.insert
    开发信息:
    处理信息: 保存记录
    -->
    <insert id="insert"
            parameterType="${entityPackage}.${entityName}">
        INSERT INTO ${tableInfo.tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list tableInfo.columnInfos as columnInfo>
            <if test="${columnInfo.javaName} != null">
            ${columnInfo.name},
            </if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list tableInfo.columnInfos as columnInfo>
            <if test="${columnInfo.javaName} != null">
            ${"#"}{${columnInfo.javaName},jdbcType=${columnInfo.type}},
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
        UPDATE ${tableInfo.tableName}
        <set>
        <#list tableInfo.columnInfos as columnInfo>
            <if test="${columnInfo.javaName} != null">
            ${columnInfo.name} = ${"#"}{${columnInfo.javaName},jdbcType=${columnInfo.type}},
            </if>
        </#list>
        </set>
        WHERE 1=1
        <include refid="whereCondition"/>
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
        <#list tableInfo.columnInfos as columnInfo>
        ${columnInfo.name} = ${"#"}{${columnInfo.javaName},jdbcType=${columnInfo.type}},
        </#list>
        </set>
        WHERE 1=1
        <include refid="whereCondition"/>
    </update>

    <!--
    方法名称: delete
    调用路径:${entityName}Mapper.delete
    开发信息:
    处理信息: 删除记录
    -->
    <delete id="delete"
            parameterType="${entityPackage}.${entityName}">
        DELETE FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereCondition"/>
    </delete>

    <!--
    方法名称: findBy
    调用路径: ${entityName}Mapper.findBy
    开发信息:
    处理信息: 根据主键查询记录
    -->
    <select id="findBy"
            parameterType="${entityPackage}.${entityName}"
            resultType="${entityPackage}.${entityName}">
        SELECT
        <include refid="baseColumnList"/>
        FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereCondition"/>
    </select>

    <!--
    方法名称: countBy
    调用路径: ${entityName}Mapper.countBy
    开发信息:
    处理信息: 根据主键统计记录
    -->
    <select id="countBy"
            parameterType="${entityPackage}.${entityName}"
            resultType="${entityPackage}.${entityName}">
        SELECT
        count(1)
        FROM ${tableInfo.tableName}
        WHERE 1=1
        <include refid="whereCondition"/>
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
        <include refid="whereCondition"/>
        <if test="columnSort != null">
            ORDER BY ${r'${columnSort}'}
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
        <include refid="whereCondition"/>
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
        <include refid="whereCondition"/>
        <if test="columnSort != null">
            ORDER BY ${r'${columnSort}'}
        </if>
        limit 0,100
    </select>

    <!--用户自定义代码开始-->
${userCustomCode}
    <!--用户自定义代码结束-->
</mapper>