package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource; //this takes care of registering Driver, and connection pooling

public class BasicDataSourceConn {

    public static void main(String[] args) {

        MysqlDataSource mysqlDS = null;

        try {
            mysqlDS = new MysqlDataSource();

            mysqlDS.setURL("jdbc:mysql://localhost:3306");
            mysqlDS.setUser("root");
            mysqlDS.setPassword("root");

            Connection conn = mysqlDS.getConnection();

            if (conn != null) {
                System.out.println("Connection has been established");
            } else {
                System.out.println("Connection error");
            }
        } catch (SQLException ex) { ex.printStackTrace();}
    }

}
