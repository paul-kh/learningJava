package com.paulchheang.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;

public class Exploring_RowSets {

    public static void main(String[] args) {
        // Join 3 tables
        //Using Try resource block to create a Connection object (Resource auto closed after Try block)
        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            //Create CachedRowSet of 'delpartners' table
            CachedRowSet partnersRS = DBUtils.getCachedRowSet("");
            partnersRS.setCommand("select * from delpartners");
            partnersRS.execute(conn);

            //Create CachedRowSet of 'delvehicles' table
            CachedRowSet vehiclesRS = DBUtils.getCachedRowSet("");
            vehiclesRS.setCommand("select * from delvehicles");
            vehiclesRS.execute(conn);

            //Create CachedRowSet of 'deliveries' table
            CachedRowSet deliveriesRS = DBUtils.getCachedRowSet("");
            deliveriesRS.setCommand("select * from deliveries");
            deliveriesRS.execute(conn);

            //Create JoinRowSet object: partners-deliveries, and vehicles-delivery
            JoinRowSet joinRSPartnerDelivery = RowSetProvider.newFactory().createJoinRowSet();
            //Create JoinRowSet object: vehicles-delivery
            JoinRowSet joinRSVehicleDelivery = RowSetProvider.newFactory().createJoinRowSet();
            //Create final JoinRowSet object for the result of joining the above 2 JoinRowSets
            JoinRowSet joinRS = RowSetProvider.newFactory().createJoinRowSet();

            //Add the join between 'vehicles' and 'deliveries' tables
            joinRSVehicleDelivery.addRowSet(vehiclesRS, "vid");
            joinRSVehicleDelivery.addRowSet(deliveriesRS, "vid");

            //Add the join between 'partners' and 'deliveries' tables
            joinRSPartnerDelivery.addRowSet(partnersRS, "pid");
            joinRSPartnerDelivery.addRowSet(deliveriesRS.createCopyNoConstraints(), "pid");
            /*  Note: We can't use 'deliveriesRS again since it was used once already when creating
                the above join between 'vehicles' and 'deliveries'.
                We have to create a copy of the 'deliveriesRS' to create the join between 'partners'
                and 'deliveries' */

            //Add the join between the 2 above joins
            joinRS.addRowSet(joinRSVehicleDelivery, "did");
            joinRS.addRowSet(joinRSPartnerDelivery, "did");

            int rowNum = 1;

            while(joinRS.next()){

                String fName = joinRS.getString("first_name");
                String color = joinRS.getString("color");
                String vType = joinRS.getString("vehicle_type");
                String destination = joinRS.getString("destination");

                String stdData = "\nRow #%d:  %s | %s | %s | %s";
                System.out.format(stdData, rowNum, fName, color, vType, destination);
                rowNum++;
            }

            joinRS.close();
            joinRSVehicleDelivery.close();
            joinRSPartnerDelivery.close();
            partnersRS.close();
            vehiclesRS.close();
            deliveriesRS.close();
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}