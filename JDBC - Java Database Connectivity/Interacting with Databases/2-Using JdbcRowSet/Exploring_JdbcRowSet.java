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

        try (JdbcRowSet jdbcRS = DBUtils.getJdbcRowSet("DeliveryService")){

            jdbcRS.setCommand("select * from delpartners");
            jdbcRS.execute();

            System.out.println("Moving around in a JdbcRowSet: \n");

            jdbcRS.first();
            displayRow("first()", jdbcRS);

            jdbcRS.relative(2);
            displayRow("relative(2)", jdbcRS);

            jdbcRS.previous();
            displayRow("previous()", jdbcRS);

            jdbcRS.absolute(4);
            displayRow("absolute(4)", jdbcRS);

            jdbcRS.last();
            displayRow("last()", jdbcRS);

            jdbcRS.relative(-1); //Similar to jdbcRS.previous();
            displayRow("relative(-1)", jdbcRS);

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}