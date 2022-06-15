package com.paulchheang.jdbc;

import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

// Create a class that filters for delivery partners whose hourly_rate is between
// 'lowRate' and 'highRate'
public class DeliveryPartnerFilter implements Predicate {

    private int lowRate;
    private int highRate;
    private String colName = null;
    private int colNumber = -1;

    //Constructor that accepts 'colNumber' for the table column number to be filtered
    public DeliveryPartnerFilter(int lo, int hi, int colNumber) {
        this.lowRate = lo;
        this.highRate = hi;
        this.colNumber = colNumber;
    }

    //Constructor that accepts 'colName' for the table column name/label to be filtered
    public DeliveryPartnerFilter(int lo, int hi, String colName) {
        this.lowRate = lo;
        this.highRate = hi;
        this.colName = colName;
    }

    @Override
    public boolean evaluate(RowSet rs) {

        if (rs == null) {

            return false;

        }

        FilteredRowSet frs = (FilteredRowSet) rs;
        boolean evaluation = false;

        try {

            double columnValue = frs.getDouble(this.colNumber); //because the 'hourly_rate' field is of type double

            if ((columnValue >= this.lowRate) && (columnValue <= this.highRate)) {

                evaluation = true;

            }

        } catch (SQLException e) {

            return false;

        }

        return evaluation;
    }



    @Override
    public boolean evaluate(Object value, int columnNumber) throws SQLException {

        boolean evaluation = true;

        if (colNumber == columnNumber) {

            double columnValue = ((Double) value).doubleValue();

            if ((columnValue >= this.lowRate) && (columnValue <= this.highRate)) {

                evaluation = true;

            } else {

                evaluation = false;

            }
        }
        return evaluation;
    }


    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {

        boolean evaluation = true;

        if (columnName.equalsIgnoreCase(this.colName)) {

            double columnValue = ((Double) value).doubleValue();

            if ((columnValue >= this.lowRate) && (columnValue <= this.highRate)) {

                evaluation = true;

            } else {

                evaluation = false;
            }
        }
        return evaluation;
    }

}