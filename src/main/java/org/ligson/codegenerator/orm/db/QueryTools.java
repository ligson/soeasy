package org.ligson.codegenerator.orm.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ligson on 2016/1/28.
 */
public class QueryTools {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = DriverManager.getConnection()
        } catch (ClassNotFoundException e) {
        }

    }
}
