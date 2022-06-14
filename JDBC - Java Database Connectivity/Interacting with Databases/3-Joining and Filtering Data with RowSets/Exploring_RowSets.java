package com.paulchheang.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;

public class Exploring_RowSets {

    public static void main(String[] args) {

        //Using Try resource block to create a Connection object (Resource auto closed after Try block)
        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            CachedRowSet partnersRS = DBUtils.getCachedRowSet("");
            partnersRS.setCommand("select * from delpartners");
            partnersRS.execute(conn);

            CachedRowSet deliveriesRS = DBUtils.getCachedRowSet("");
            deliveriesRS.setCommand("select * from deliveries");
            deliveriesRS.execute(conn);

            JoinRowSet joinRS = RowSetProvider.newFactory().createJoinRowSet();

            //Specify the joining fields
            joinRS.addRowSet(partnersRS, "pid");
            joinRS.addRowSet(deliveriesRS, "pid");

            int rowNum = 1;

            while(joinRS.next()){

                String fName = joinRS.getString("first_name");
                boolean isFT = joinRS.getBoolean("is_fulltime");
                String destination = joinRS.getString("destination");

                String stdData = "\nRow #%d:  %s | %s | %s";
                System.out.format(stdData, rowNum, fName, isFT, destination);
                rowNum++;
            }

            joinRS.close();
            partnersRS.close();
            deliveriesRS.close();
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}