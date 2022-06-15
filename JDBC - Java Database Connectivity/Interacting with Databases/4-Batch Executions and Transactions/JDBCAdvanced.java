package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCAdvanced {

    public static void main(String[] args) {

        Statement stmnt;

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")){

            stmnt = conn.createStatement();

            //Add each query to batch
            stmnt.addBatch("insert into delvehicles values (16, 'Red', 'Truck', 'CPAUL16')");
            stmnt.addBatch("insert into delvehicles values (17, 'Orange', 'Van', 'CPAUL17')");
            stmnt.addBatch("insert into delvehicles values (18, 'Grey', 'Van', 'CPAUL18')");
            stmnt.addBatch("insert into delvehicles values (19, 'Pink', 'Truck', 'CPAUL19')");

            int[] count = stmnt.executeBatch(); // count[1,1,1,1] -- 1 is the number of row affected by each query

            System.out.println("Values inserted successfully: \n" + Arrays.toString(count));

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
