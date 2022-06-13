package com.paulchheang.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "root";

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



