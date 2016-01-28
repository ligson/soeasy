package org.ligson.codegenerator.orm.bean;

/**
 * Created by ligson on 2016/1/28.
 *
 * @author ligson
 *         列模型
 */
public class ColumnInfo {
    /***
     * 列名
     */
    private String name;
    /***
     * 数据类型
     */
    private String type;
    /***
     * 是否主键
     */
    private boolean primaryKey;
    /***
     * 字段注释
     */
    private String remark;
    /***
     * 字段默认值
     */
    private String defaultValue;
    /***
     * 是否允许为空
     */
    private boolean nullable;
    /***
     * 字段长度
     */
    private int length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
