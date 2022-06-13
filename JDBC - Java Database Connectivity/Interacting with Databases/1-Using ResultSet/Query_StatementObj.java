package com.paulchheang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query_StatementObj {

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection("deliveryservice")){

            Statement stmnt = conn.createStatement();

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners";

           ResultSet rs = stmnt.executeQuery(query);

            System.out.println("Query has been executed successfully");

            while (rs.next()) {
                System.out.println(rs.getString("first_name") //rs.getString is mapped to varchar in db
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
