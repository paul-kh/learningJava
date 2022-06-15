package com.paulchheang.jdbc;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;

// The code to filter for delivery partners whose hourly_rate is between $19 and $21 and is_fulltime = true
// The code is using a filter class 'DeliveryPartnerFilter' that implements JDBC Predicate interface
public class Exploring_RowSets {

    //Method displaying results of the DB operations
    public static void displayRow(String label, RowSet rowSet) throws SQLException{

        String fName = rowSet.getString("first_name");
        String lName = rowSet.getString("last_name");
        double hourlyRate = rowSet.getDouble("hourly_rate");
        boolean isFT = rowSet.getBoolean("is_fulltime");

        String stdData = "\n%s:  %s | %s | %.2f | %s \n";
        System.out.format(stdData, label, fName, lName, hourlyRate, isFT);
    }

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            FilteredRowSet partnersRS = RowSetProvider.newFactory().createFilteredRowSet();

            partnersRS.setCommand("select first_name, last_name, hourly_rate, is_fulltime "
                    +  "from delpartners");
            partnersRS.execute(conn);

            DeliveryPartnerFilter customFilter
                    = new DeliveryPartnerFilter(19, 21, true, 3, 4);

            partnersRS.setFilter(customFilter);

            int rowNum = 1;

            while(partnersRS.next()){

                displayRow("Row #" + rowNum, partnersRS);
                rowNum++;
            }

            partnersRS.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}