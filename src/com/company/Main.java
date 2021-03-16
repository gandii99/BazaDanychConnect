package com.company;

import connection.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        List<String> imiona = new ArrayList<String>();
        String sql = "SELECT * FROM dziekanat.studenci";

        Connect connect = new Connect("195.150.230.210", "5434", "2021_urban_radoslaw", "2021_urban_radoslaw", "33209");
        Statement statement = connect.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        boolean czy_tutul = true;
        for(int i=1; i<=columnsNumber; i++){
            System.out.print(rs.getMetaData().getColumnName(i) + "\t\t\t");
        }
        System.out.println();
        while (rs.next()) {
            for(int i=1; i<=columnsNumber; i++){
                System.out.print(rs.getString(i) + "\t\t\t\t");
            }
            System.out.println();
        }
        connect.close();
    }
}
