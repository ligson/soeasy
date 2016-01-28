package org.ligson.codegenerator.orm.db;

import org.ligson.codegenerator.orm.bean.ColumnInfo;
import org.ligson.codegenerator.orm.bean.TableInfo;
import org.ligson.codegenerator.orm.config.OrmConfig;

import static java.util.stream.Collectors.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligson on 2016/1/28.
 */
public class QueryTools {
    private static Connection connection;
    private static OrmConfig ormConfig = OrmConfig.getInstance();

    static {
        try {
            Class.forName(ormConfig.getDriverName());
            connection = DriverManager.getConnection(ormConfig.getUrl(), ormConfig.getUsername(), ormConfig.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TableInfo getTableInfo() throws Exception {
        String sql = "SELECT cols.COLUMN_NAME,cols.DATA_TYPE,cols.CHARACTER_MAXIMUM_LENGTH,cols.COLUMN_DEFAULT,cols.COLUMN_COMMENT,cols.COLUMN_KEY FROM information_schema.`COLUMNS` cols where cols.TABLE_NAME=? AND cols.TABLE_SCHEMA=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ormConfig.getTableName());
        ps.setString(2, ormConfig.getDatabaseName());
        ResultSet rs = ps.executeQuery();
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableName(ormConfig.getTableName());
        List<ColumnInfo> columnInfos = new ArrayList<>();
        while (rs.next()) {
            String columnName = rs.getString(1);
            String dataType = rs.getString(2);
            Integer max = rs.getInt(3);
            String defaultValue = rs.getString(4);
            String comment = rs.getString(5);
            String key = rs.getString(6);

            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setDefaultValue(defaultValue);
            columnInfo.setLength(max);
            columnInfo.setName(columnName);
            columnInfo.setRemark(comment);
            columnInfo.setType(dataType);
            if ("PRI".equals(key)) {
                columnInfo.setPrimaryKey(true);
                tableInfo.setPrimaryKeyName(columnName);
            }
            columnInfos.add(columnInfo);
        }
        tableInfo.setColumnInfos(columnInfos);
        rs.close();
        return tableInfo;
    }

    public QueryTools() {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        QueryTools qt = new QueryTools();
        TableInfo ti = qt.getTableInfo();
        System.out.println(ti);
    }
}
