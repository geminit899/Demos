package com.geminit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DaMengTest {
    public static void main(String[] args) throws Exception {
        String driver= "dm.jdbc.driver.DmDriver";
        String url= "jdbc:dm://192.168.0.29:5236/SYSDBA";
        String username="SYSDBA";
        String password="SYSDBA";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

//        int id = stmt.executeUpdate("create table tyx (id int not null, name char(32) not null, age int not null)");

//        int code = stmt.executeUpdate("insert into tyx (id, name, age) values (1, 'tyx', 25);");


        ResultSet rs = stmt.executeQuery("SELECT segment_name AS TABLENAME, BYTES FROM user_segments where segment_name = upper('tyx');");
//        ResultSet rs = stmt.executeQuery("select count(*) from tyx;");
        ResultSetMetaData metaData = rs.getMetaData();
        if (rs.next()) {
            String row = "";
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String name = metaData.getColumnName(i);
                row += name + " : " + rs.getString(i) + ", ";
            }
            System.out.println(row);
        }
        rs.close();


//        ResultSet rs = stmt.executeQuery("SELECT * FROM tyx");
//        int newID = 1;
//        if (rs.next()) {
//            String userName = rs.getString("age");
//            System.out.println("age:" +userName);
//
//        }else{
//            System.out.println("no data");
//        }
//        rs.close();


        conn.close();
    }
}
