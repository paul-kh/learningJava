package com.paulchheang.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource; //this takes care of registering Driver, and connection pooling

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
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

    //Method defining JdbcRowSet with Data Source connection encapsulated
    public static JdbcRowSet getJdbcRowSet(String schemaName){

        JdbcRowSet jdbcRS = null;

        try {

            jdbcRS = RowSetProvider.newFactory().createJdbcRowSet();

            // RowSet already associated with Connection/Data Source
            jdbcRS.setUrl(dbURL + schemaName);
            jdbcRS.setUsername(username);
            jdbcRS.setPassword(password);

        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return jdbcRS;
    }
}



