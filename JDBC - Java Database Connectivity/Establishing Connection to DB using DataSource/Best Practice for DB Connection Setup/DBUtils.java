package com.paulchheang.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource; //this takes care of registering Driver, and connection pooling
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection getMysqlConnection(String schemaName) {

        MysqlDataSource mysqlDS = null;
        Connection conn = null;

        try {
            mysqlDS = new MysqlDataSource();

            mysqlDS.setURL(dbURL + schemaName);
            mysqlDS.setUser(username);
            mysqlDS.setPassword(password);

            conn = mysqlDS.getConnection();
        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return conn;
    }
}



