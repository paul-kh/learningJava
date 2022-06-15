package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//The code is to run queries in Transactions
//This is to make sure all queries will execute successfully or none of them will succeed
// if one query failed to execute
public class JDBCAdvanced {

    public static void main(String[] args) throws SQLException {

        Statement stmnt;
        String query;
        Connection conn = null;

        try{

            conn = DBUtils.getMysqlConnection("DeliveryService");
            conn.setAutoCommit(false); //Turn off auto commit

            stmnt = conn.createStatement();

            //The below query is made to get successful execution since the partner with id=107 not exist yet
            query = "insert into delpartners values (107, 'Kylie', 'Kass', 22.0, false)";
            stmnt.executeUpdate(query);

            //The below query is made to get fail execution since vehicle with id=16 already exists
            query = "insert into delvehicles values (16, 'Orange', 'Van', 'LOONY17')";
            stmnt.executeUpdate(query);

            conn.commit(); //Commit to DB after the last query
            System.out.println("Rows have been successfully inserted");

        }
        catch (SQLException ex) {
            System.out.println("An exception was thrown. Rolling back the Tx...");
            conn.rollback(); //Rollback log data that might have written when any query execution failed
            ex.printStackTrace();
        }
        finally {
            conn.close();
        }
    }
}
