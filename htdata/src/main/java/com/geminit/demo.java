package com.geminit;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class demo {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.114:3306/geminit",
//                "root", "ht1234");
//        conn.setAutoCommit(false);
//        //get all prileage in database
//        String sql = "insert into mmds(name, age, gender, location, a, b, y) values(?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        for (int i = 51; i <= 100; i++) {
//            for (int j = 0; j < 10000; j++) {
//                statement.setString(1, "htdata");
//                statement.setString(2, "25");
//                statement.setString(3, "male");
//                statement.setString(4, "chengdu gaoxing rianfuruanjianyuan E");
//                statement.setDouble(5, 1.0);
//                statement.setDouble(6, 1.0);
//                statement.setString(7, "1");
//                statement.addBatch();
//            }
//            statement.executeBatch();
//            conn.commit();
//            System.out.println(i + "万");
//        }
//        statement.close();
//        conn.close();

        File mmd = new File("/Users/geminit/Desktop/mmd.csv");
        FileOutputStream fos = new FileOutputStream(mmd);

        for (int i = 1; i <= 100; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 100000; j++) {
                builder.append("htdata,25,male,chengdu gaoxing rianfuruanjianyuan E,1.0,1.0,1\n");
            }
            fos.write(builder.toString().getBytes());
            fos.flush();
            System.out.println(i + "十万");
        }
        fos.close();
    }
}
