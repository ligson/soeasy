package org.ligson.codegenerator.orm.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligso on 2016/3/22.
 * 类型对应关系
 */
public class TypeMapper {

    /***
     * 数据库类型
     */
    private List<String> dbTypes = new ArrayList<>();
    /**
     * orm对应的类型
     */
    private String ormType;

    /***
     * java对应的类型
     */
    private Class javaType;

    public List<String> getDbTypes() {
        return dbTypes;
    }

    public void setDbTypes(List<String> dbTypes) {
        this.dbTypes = dbTypes;
    }

    public String getOrmType() {
        return ormType;
    }

    public void setOrmType(String ormType) {
        this.ormType = ormType;
    }

    public Class getJavaType() {
        return javaType;
    }

    public void setJavaType(Class javaType) {
        this.javaType = javaType;
    }

    public TypeMapper(List<String> dbTypes, String ormType, Class javaType) {
        this.dbTypes = dbTypes;
        this.ormType = ormType;
        this.javaType = javaType;
    }
}
