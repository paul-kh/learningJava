package com.paulchheang.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "root";

    //Method defining CachedRowSet with Data Source connection encapsulated
    public static CachedRowSet getCachedRowSet(String schemaName){

        CachedRowSet cachedRS = null;

        try {

            cachedRS = RowSetProvider.newFactory().createCachedRowSet();

            // RowSet already associated with Connection/Data Source
            cachedRS.setUrl(dbURL + schemaName);
            cachedRS.setUsername(username);
            cachedRS.setPassword(password);

        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return cachedRS;
    }
}



