package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        DeliveryPartnerQueries dpq = new DeliveryPartnerQueries();

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            System.out.println("\n##############\n");

            System.out.println("Updating hourly rates for FT partners...\n");

            int status = dpq.applyPayAdjustment(conn, 2, true);

            System.out.println("Status returned: " + status);

            System.out.println("\n##############");
            System.out.println("Retrieving all Delivery Partner details...\n");

            ResultSet rs = dpq.getAllDelPartners(conn);

            while (rs.next()) {
                System.out.println(rs.getString("first_name")
                        + "\t" + rs.getString("last_name")
                        + "\t" + rs.getDouble("hourly_rate")
                        + "\t" + rs.getBoolean("is_fulltime"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
