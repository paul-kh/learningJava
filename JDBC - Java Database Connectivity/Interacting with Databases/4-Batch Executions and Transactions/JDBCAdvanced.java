package com.paulchheang.jdbc;

import java.sql.*;
import java.util.Arrays;

/*
This program is to run queries in 2 batches with savepoints
All queries in the first batch will commit since no query in this batch is invalid
All queries in the 2nd batch will commit since there is one invalid query */
public class JDBCAdvanced {

    public static void main(String[] args) throws SQLException {

        int[] count = {};
        Connection conn = null;
        Savepoint sp = null;

        try{

            conn = DBUtils.getMysqlConnection("DeliveryService");
            conn.setAutoCommit(false); //Turn off auto commit

            PreparedStatement insertPS = DBUtils.getInsertVehiclePS(conn);

            //First batch - all queries will get committed
            DBUtils.addToInsertVehicleBatch(insertPS, 16, "Red", "Truck", "LOONY16");
            DBUtils.addToInsertVehicleBatch(insertPS, 17, "Orange", "Van", "LOONY17");
            DBUtils.addToInsertVehicleBatch(insertPS, 18, "Grey", "Van", "LOONY18");
            DBUtils.addToInsertVehicleBatch(insertPS, 19, "Pink", "Truck", "LOONY19");

            count = insertPS.executeBatch();
            sp = conn.setSavepoint("BatchOne");
            System.out.println("First batch executed: " + Arrays.toString(count));

            // 2nd batch - all queries will not get committed because there's one invalid query
            DBUtils.addToInsertVehicleBatch(insertPS, 20, "Yellow", "Truck", "LOONY20");
            DBUtils.addToInsertVehicleBatch(insertPS, 19, "Pink", "Truck", "LOONY19"); //Invalid since id=19 exists
            DBUtils.addToInsertVehicleBatch(insertPS, 21, "Green", "Van", "LOONY21");

            count = insertPS.executeBatch();
            System.out.println("Second batch executed: " + Arrays.toString(count));

            conn.commit();

        }
        catch (SQLException ex) {

            if(sp != null){

                System.out.println("An exception was thrown. Rolling back to " + sp.getSavepointName());
                conn.rollback(sp); //Rollback to the savepoint created
                conn.commit(); //commit all queries upto the savepoint created
            }
            else{
                System.err.println("Errors detected. Rolling back everything...");
                conn.rollback();
            }

            ex.printStackTrace();
        }
        finally {
            conn.close();
        }
    }
}
