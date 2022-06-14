package com.paulchheang.jdbc;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

import javax.sql.RowSet;

public class Exploring_JdbcRowSet {

    public static void displayRow(String label, RowSet rowSet) throws SQLException{

        String fName = rowSet.getString("first_name");
        String lName = rowSet.getString("last_name");
        double hourlyRate = rowSet.getDouble("hourly_rate");
        boolean isFT = rowSet.getBoolean("is_fulltime");

        String stdData = "\n%s:  %s | %s | %.2f | %s \n";
        System.out.format(stdData, label, fName, lName, hourlyRate, isFT);
    }

    public static void main(String[] args) {

        //Add new row to table data if number of part-time emp < 5
        try (JdbcRowSet jdbcRS = DBUtils.getJdbcRowSet("DeliveryService")){

            jdbcRS.setCommand("select * from delpartners where is_fulltime = false");
            jdbcRS.execute();

            jdbcRS.last(); // Move the cursor to the last row
            int numPT = jdbcRS.getRow(); //Count the total rows returned
            System.out.println("Number of part-time partners: " + numPT);

            if(numPT < 5){

                jdbcRS.moveToInsertRow(); //Move the cursor to new row for insertion

                jdbcRS.updateString("first_name", "Kylie");
                jdbcRS.updateString("last_name", "Kass");
                jdbcRS.updateDouble("hourly_rate", 22.0);
                jdbcRS.updateBoolean("is_fulltime", false);

                jdbcRS.insertRow();

                jdbcRS.last();
                displayRow("Added part-time partner: ", jdbcRS);

            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}