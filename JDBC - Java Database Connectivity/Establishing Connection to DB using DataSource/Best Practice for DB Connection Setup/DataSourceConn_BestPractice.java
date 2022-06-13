package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConn_BestPractice {

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection(" ")) {

            if (conn != null) {
                System.out.println("Connection has been established");
            } else {
                System.out.println("Connection error");
            }
        } catch (SQLException ex) { ex.printStackTrace();}
    }

}
