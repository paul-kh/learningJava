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

            cachedRS.setCommand("select * from delpartners where is_fulltime = false");
            cachedRS.execute(conn);

            cachedRS.last();
            int numPT = cachedRS.getRow();
            System.out.println("Number of part-time partners: " + numPT);

            if(numPT < 5){

                cachedRS.moveToInsertRow();

                cachedRS.updateNull("id"); //To update Auto_Increment field which is "id"
                cachedRS.updateString("first_name", "Brian");
                cachedRS.updateString("last_name", "Walters");
                cachedRS.updateDouble("hourly_rate", 25.0);
                cachedRS.updateBoolean("is_fulltime", false);

                cachedRS.insertRow();
                cachedRS.moveToCurrentRow();

                cachedRS.last();
                displayRow("Added part-time partner: ", cachedRS);
            }

            cachedRS.acceptChanges(conn);

            cachedRS.close();
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}