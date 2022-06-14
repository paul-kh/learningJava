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

            CachedRowSet cachedRS = DBUtils.getCachedRowSet("");

            cachedRS.setCommand("select * from delpartners");
            cachedRS.execute(conn);

            int removedRows = 0;

            while(cachedRS.next()){

                if(cachedRS.getBoolean("is_fulltime") == false
                        && cachedRS.getDouble("hourly_rate") > 20){

                    displayRow("Removing row: ", cachedRS);
                    cachedRS.deleteRow();

                    removedRows++;
                }
            }

            System.out.println("\nNumber of deleted rows: " + removedRows);

            cachedRS.acceptChanges(conn);

            cachedRS.close();
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}