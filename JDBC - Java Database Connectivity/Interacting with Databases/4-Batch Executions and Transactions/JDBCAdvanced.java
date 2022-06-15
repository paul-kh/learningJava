package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCAdvanced {

    public static void main(String[] args) {

        Statement stmnt;

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            PreparedStatement insertPS = DBUtils.getInsertVehiclePS(conn);

            DBUtils.addToInsertVehicleBatch(insertPS, 16, "Red", "Truck", "CPAUL16");
            DBUtils.addToInsertVehicleBatch(insertPS, 17, "Orange", "Van", "CPAUL17");
            DBUtils.addToInsertVehicleBatch(insertPS, 18, "Grey", "Van", "CPAUL18");
            DBUtils.addToInsertVehicleBatch(insertPS, 19, "Pink", "Truck", "CPAUL19");

            int[] count = insertPS.executeBatch();

            System.out.println("Values inserted successfully: \n" + Arrays.toString(count));
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
