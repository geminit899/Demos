package com.geminit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class HiveTest {
    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.0.114:11111/default", "hive", "hive");
        Statement stmt = conn.createStatement();
        ResultSet set = stmt.executeQuery("select * from test;");
        ResultSetMetaData meta = set.getMetaData(); //获取字段
        while(set.next())
        {
            for(int i = 1; i <= meta.getColumnCount(); i++)
            {
                System.out.print(set.getString(i) + " ");
            }
            System.out.println();
        }
        System.out.println("第一条sql语句执行完毕");
    }
}
