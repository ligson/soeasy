package org.ligson.cg.orm.db;

import org.ligson.cg.orm.bean.ColumnInfo;
import org.ligson.cg.orm.bean.TableInfo;
import org.ligson.cg.orm.config.OrmConfig;
import org.ligson.cg.orm.utils.EntityTemplate;
import org.ligson.cg.orm.utils.MapperTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
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
    private static Logger logger = LoggerFactory.getLogger(QueryTools.class);

    static {
        try {
            Class.forName(ormConfig.getDriverName());
            connection = DriverManager.getConnection(ormConfig.getUrl(), ormConfig.getUsername(), ormConfig.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TableInfo getTableInfo() throws Exception {
        //ALTER TABLE account_center4.login_log COMMENT '登录日志表';
        //SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.`TABLES` WHERE TABLE_NAME='t_user' AND TABLE_SCHEMA='pay_center';
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
            String dbType = rs.getString(2).toUpperCase();
            Integer max = rs.getInt(3);
            String defaultValue = rs.getString(4);
            String comment = rs.getString(5);
            String key = rs.getString(6);

            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setDefaultValue(defaultValue);
            columnInfo.setLength(max);
            columnInfo.setName(columnName);
            columnInfo.setRemark(comment);

            columnInfo.setDbType(dbType);
            columnInfo.setJavaName(convert2JavaName(columnName));
            columnInfo.setJavaType(TypeMap.getJavaType(dbType));
            columnInfo.setOrmType(TypeMap.getOrmType(dbType));
            if ("PRI".equals(key)) {
                columnInfo.setPrimaryKey(true);
                tableInfo.setPrimaryKey(columnInfo);
            }
            columnInfos.add(columnInfo);
        }
        tableInfo.setColumnInfos(columnInfos);
        rs.close();

        sql = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.`TABLES` WHERE TABLE_NAME='" + ormConfig.getTableName() + "' AND TABLE_SCHEMA='" + ormConfig.getDatabaseName() + "'";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            String remark = rs.getString("TABLE_COMMENT");
            tableInfo.setRemark(remark);
        }
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
            logger.info("数据库断开连接");
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
        MapperTemplate.write(ti);
        logger.info("实体Mapper生成成功.....");
        EntityTemplate.write(ti);
        logger.info("实体生成成功.....");
        qt = null;
        System.gc();
    }
}
