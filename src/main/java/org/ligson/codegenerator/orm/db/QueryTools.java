package org.ligson.codegenerator.orm.db;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;
import org.ligson.codegenerator.orm.bean.ColumnInfo;
import org.ligson.codegenerator.orm.bean.TableInfo;
import org.ligson.codegenerator.orm.config.ConfigUtils;
import org.ligson.codegenerator.orm.config.OrmConfig;
import org.ligson.codegenerator.orm.template.utils.MapperTemplate;

import static java.util.stream.Collectors.*;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            columnInfo.setJavaName(convert2JavaName(columnName));
            columnInfo.setJavaType(TypeMap.getType(dataType));
            if ("PRI".equals(key)) {
                columnInfo.setPrimaryKey(true);
                tableInfo.setPrimaryKeyName(columnName);
                tableInfo.setPrimaryKeyType(dataType);
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

    public static String convert2JavaName(String columnName) {
        String[] names = columnName.split("_");
        if (names.length == 1) {
            return columnName;
        } else {
            StringBuilder builder = new StringBuilder();
            for (int idx = 0; idx < names.length; idx++) {
                String name = names[idx];
                if (idx == 0) {
                    builder.append(name);
                } else {
                    builder.append(Character.toUpperCase(name.charAt(0))).append(name.substring(1));
                }
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        //println convert2JavaName("user")
        QueryTools qt = new QueryTools();
        TableInfo ti = qt.getTableInfo();
        System.out.println(ti);
        // <result column="ID" property="id" jdbcType="BIGINT"/>
        for (ColumnInfo ci : ti.getColumnInfos()) {
            String javaPropertyName = convert2JavaName(ci.getName());
            System.out.printf("<result column=\"%s\" property=\"%s\" jdbcType=\"%s\"/>\n", ci.getName(), javaPropertyName, ci.getType());
        }

        MapperTemplate.write(ti);

    }
}
