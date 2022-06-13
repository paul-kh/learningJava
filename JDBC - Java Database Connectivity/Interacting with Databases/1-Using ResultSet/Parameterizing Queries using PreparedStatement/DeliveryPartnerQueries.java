package com.paulchheang.jdbc;

import java.sql.*;

public class DeliveryPartnerQueries {

    public ResultSet getAllDelPartners(Connection conn) {

        try {
            Statement stmnt = conn.createStatement();

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners";

            return stmnt.executeQuery(query);
        }
        catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet getDelPartnerById(Connection conn, int id) {

        try {

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            return ps.executeQuery();
        }
        catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    // INSERT Query
    public int addNewDelPartner(Connection conn, String fName, String lName, double hourlyRate, boolean isFT){

        int status = 0;

        try {
            String query = "insert into delpartners "
                    + "(first_name, last_name, hourly_rate, is_fulltime) "
                    + "values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setDouble(3, hourlyRate);
            ps.setBoolean(4, isFT);

            status = ps.executeUpdate(); // returning number of rows affected

        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return status;

    }

    //UPDATE Query
    public int applyPayAdjustment(Connection conn, double adjAmount, boolean isFT){

        int status = 0;

        try {

            String query = "update delpartners "
                    + "set hourly_rate = hourly_rate + ?"
                    + "where is_fulltime = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDouble(1, adjAmount);
            ps.setBoolean(2, isFT);

            status = ps.executeUpdate(); // returning number of affected rows

        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return status;
    }

    //DELETE Query
    public int deleteDeliveryPartner(Connection conn, int id){

        int status = 0;

        try {

            String query = "delete from delpartners "
                    + "where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, id);

            status = ps.executeUpdate();

        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return status;
    }
}