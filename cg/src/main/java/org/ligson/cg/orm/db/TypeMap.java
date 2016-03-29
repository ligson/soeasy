package org.ligson.cg.orm.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ligso on 2016/1/30.
 *
 * @author ligson
 */
public class TypeMap {
    public static final TypeMapper VARCHAR_TYPE;
    public static final TypeMapper DATETIME_TYPE;
    public static final TypeMapper INT_TYPE;
    public static final TypeMapper TINYINT_TYPE;
    public static final TypeMapper BIGINT_TYPE;
    private static List<TypeMapper> mappers = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(TypeMap.class);

    static {
        List<String> dbTypes = new ArrayList<>();
        dbTypes.add("VARCHAR");
        VARCHAR_TYPE = new TypeMapper(dbTypes, "VARCHAR", String.class);
        dbTypes = new ArrayList<>();
        dbTypes.add("DATETIME");
        dbTypes.add("TIMESTAMP");
        DATETIME_TYPE = new TypeMapper(dbTypes, "TIMESTAMP", Date.class);
        dbTypes = new ArrayList<>();
        dbTypes.add("INT");
        dbTypes.add("INTEGER");
        INT_TYPE = new TypeMapper(dbTypes, "INTEGER", Integer.class);
        dbTypes = new ArrayList<>();
        dbTypes.add("TINYINT");
        TINYINT_TYPE = new TypeMapper(dbTypes, "TINYINT", Boolean.class);
        dbTypes = new ArrayList<>();
        dbTypes.add("BIGINT");
        BIGINT_TYPE = new TypeMapper(dbTypes, "BIGINT", BigInteger.class);

        mappers.add(VARCHAR_TYPE);
        mappers.add(DATETIME_TYPE);
        mappers.add(INT_TYPE);
        mappers.add(TINYINT_TYPE);
        mappers.add(BIGINT_TYPE);
    }

    /***
     * 根据数据库类型获取orm类型
     *
     * @param dbType 数据库类型
     * @return orm类型
     */
    public static String getOrmType(String dbType) {
        dbType = dbType.toUpperCase();
        for (TypeMapper mapper : mappers) {
            if (mapper.getDbTypes().contains(dbType)) {
                return mapper.getOrmType();
            }
        }
        logger.error("数据库类型:{},没有对应的ORM类型");
        return null;
    }

    /***
     * 根据数据库类型查询java类型
     *
     * @param dbType 数据库类型
     * @return java类型
     */
    public static Class getJavaType(String dbType) {
        dbType = dbType.toUpperCase();
        for (TypeMapper mapper : mappers) {
            if (mapper.getDbTypes().contains(dbType)) {
                return mapper.getJavaType();
            }
        }
        logger.error("数据库类型:{},没有对应的Java类型");
        return null;
    }
}
