package com.paulchheang.jdbc;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.SQLException;

public class Exploring_CachedRowSet {

    public static void displayRow(String label, RowSet rowSet) throws SQLException{

        String fName = rowSet.getString("first_name");
        String lName = rowSet.getString("last_name");
        double hourlyRate = rowSet.getDouble("hourly_rate");
        boolean isFT = rowSet.getBoolean("is_fulltime");

        String stdData = "\n%s:  %s | %s | %.2f | %s \n";
        System.out.format(stdData, label, fName, lName, hourlyRate, isFT);
    }

    public static void main(String[] args) {

        //Using Try resource block to create a Connection object (Resource auto closed after Try block)
        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            conn.setAutoCommit(false);

            CachedRowSet cachedRS = DBUtils.getCachedRowSet(""); //no schema name

            cachedRS.setCommand("select * from delpartners");
            cachedRS.execute(conn);

            int updatedRows = 0;

            while(cachedRS.next()){

                if(!cachedRS.getBoolean("is_fulltime")){

                    cachedRS.updateDouble("hourly_rate", 26.0);
                    cachedRS.updateRow();

                    displayRow("Updated record: ", cachedRS);
                    updatedRows++;
                }
            }

            cachedRS.acceptChanges(conn); //Push through to DB using the currently open Connection

            cachedRS.close(); //Close the CachedRowSet object resource

            System.out.println("\nNumber of updated rows: " + updatedRows);

        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}