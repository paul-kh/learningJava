package com.paulchheang.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "root";

    //Create a Connection object to DB
    public static Connection getMysqlConnection(String schemaName){

        MysqlDataSource mysqlDS = null;
        Connection conn = null;

        try {
            mysqlDS = new MysqlDataSource();

            mysqlDS.setURL("jdbc:mysql://localhost:3306/" + schemaName);
            mysqlDS.setUser(username);
            mysqlDS.setPassword(password);

            conn = mysqlDS.getConnection();
        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return conn;
    }


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

    // CREATE 2 HELPER METHODS FOR BATCH EXECUTIONS OF PARAMETERIZED INSERT QUERIES
    //////////////////////////////////////////////////////////////////////////////////
    // 1. Method defining PreparedStatement for Parameterized Batch Inserts for table 'delvehicles'
    public static PreparedStatement getInsertVehiclePS(Connection conn){

        try {
            return conn.prepareStatement("insert into delvehicles values(?, ?, ?, ?)");
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        return null;
    }

    //2. Method adding queries as batch to a PreparedStatement object
    public static boolean addToInsertVehicleBatch(PreparedStatement ps, int id,
                                                  String color, String vehicleType,
                                                  String lPlate) {
        boolean addedQuery = false;

        try{
            ps.setInt(1, id);
            ps.setString(2, color);
            ps.setString(3, vehicleType);
            ps.setString(4, lPlate);
            ps.addBatch();

            addedQuery = true;
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }

        return addedQuery;

    }
}



