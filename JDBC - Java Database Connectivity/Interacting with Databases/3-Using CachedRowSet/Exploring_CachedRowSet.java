package com.paulchheang.jdbc;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public class Exploring_CachedRowSet {

    public static void main(String[] args) {

        try (CachedRowSet cachedRS = DBUtils.getCachedRowSet("DeliveryService")){

            System.out.println("Retrieving all Delivery Partner who are fulltime employee...\n");

            cachedRS.setCommand("select * from delpartners where is_fulltime = ?");
            cachedRS.setBoolean(1, true);
            cachedRS.execute();

            while (cachedRS.next()) {
                System.out.println(cachedRS.getString("first_name")
                        + "\t" + cachedRS.getString("last_name")+ "\t"
                        + cachedRS.getDouble("hourly_rate")
                        + "\t" + cachedRS.getBoolean("is_fulltime"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}