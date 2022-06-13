package com.paulchheang.jdbc;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class Exploring_JdbcRowSet {

    public static void main(String[] args) {


        try (JdbcRowSet jdbcRS = DBUtils.getJdbcRowSet("DeliveryService")){

            jdbcRS.setCommand("select * from delpartners");
            jdbcRS.execute();

           while (jdbcRS.next()) {
               System.out.println(jdbcRS.getString("first_name")
                       + "\t" + jdbcRS.getString("last_name")+ "\t"
                       + jdbcRS.getDouble("hourly_rate")
                       + "\t" + jdbcRS.getBoolean("is_fulltime"));
           }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
