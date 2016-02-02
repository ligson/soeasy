package org.ligson.codegenerator.orm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligson on 2016/1/28.
 */
public class TableInfo implements Serializable {
    /***
     * 表名
     */
    private String tableName;
    /***
     * 主键名
     */
    private String primaryKeyName;
    /***
     * 主键类型
     */
    private String primaryKeyType;
    /***
     * 所有的列
     */
    private List<ColumnInfo> columnInfos = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    String getPrimaryKeyType() {
        return primaryKeyType
    }

    void setPrimaryKeyType(String primaryKeyType) {
        this.primaryKeyType = primaryKeyType
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableName='" + tableName + '\'' +
                ", primaryKeyName='" + primaryKeyName + '\'' +
                ", columnInfos=" + columnInfos +
                '}';
    }
}
