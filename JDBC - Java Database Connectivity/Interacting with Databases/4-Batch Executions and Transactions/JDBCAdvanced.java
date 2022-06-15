package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

//The code is to run queries in Transactions with savepoints
//This is to partially commit the successfully executed queries to DB
// and rollback the failed queries execution based on their savepoints
public class JDBCAdvanced {

    public static void main(String[] args) throws SQLException {

        Statement stmnt;
        String query;
        Connection conn = null;
        Savepoint sp = null;

        try{

            conn = DBUtils.getMysqlConnection("DeliveryService");
            conn.setAutoCommit(false);

            stmnt = conn.createStatement();

            query = "insert into delpartners values (106, 'Brian', 'Walters', 22.0, false)"; //Valid query
            stmnt.executeUpdate(query);

            query = "insert into delvehicles values (16, 'Grey', 'Van', 'LOONY18')"; //Valid query
            stmnt.executeUpdate(query);

            sp = conn.setSavepoint("OnePlusOne");
            System.out.println("Save point created: " + sp.getSavepointName());

            query = "insert into delvehicles values (19, 'Pink', 'Truck', 'LOONY19')"; //valid query
            stmnt.executeUpdate(query);

            query = "insert into delpartners values (106, 'Aisha', 'Hussain', 22.0, false)"; //invalid since id=106 exists
            stmnt.executeUpdate(query);

            //The below code will never get hit since the exception occured at the above invalid query
            sp = conn.setSavepoint("TwoPlusTwo");
            System.out.println("Save point created: " + sp.getSavepointName());

            query = "insert into delvehicles values (20, 'Yellow', 'Truck', 'LOONY20')"; //Valid query but will not get executed
            stmnt.executeUpdate(query);

            query = "insert into delpartners values (110, 'Cuthbert', 'Crumble', 22.0, false)"; //Valid query but will not get executed
            stmnt.executeUpdate(query);

            conn.commit();
            System.out.println("Rows have been successfully inserted");

        }
        catch (SQLException ex) {

            if(sp != null){

                System.out.println("An exception was thrown. Rolling back to " + sp.getSavepointName());
                conn.rollback(sp); //rollback at the savepoint
                conn.commit();
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
