package org.ligson.cg.orm.bean;

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
     * 主键
     */
    private ColumnInfo primaryKey;
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


    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    public ColumnInfo getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnInfo primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableName='" + tableName + '\'' +
                ", primaryKey=" + primaryKey +
                ", columnInfos=" + columnInfos +
                '}';
    }
}
