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

        //Update hourly rate of all non-fulltime employees
        try (JdbcRowSet jdbcRS = DBUtils.getJdbcRowSet("DeliveryService")){

            jdbcRS.setCommand("select * from delpartners");
            jdbcRS.execute();

            int updatedRows = 0;

            while(jdbcRS.next()){

                if(!jdbcRS.getBoolean("is_fulltime")){

                    jdbcRS.updateDouble("hourly_rate", 21.0);
                    jdbcRS.updateRow();

                    displayRow("Updated record: ", jdbcRS);
                    updatedRows++;
                }
            }

            System.out.println("\nNumber of updated rows: " + updatedRows);


        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}