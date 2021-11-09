package com.geminit;

import org.apache.hive.jdbc.HiveStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiveTest {
    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn = DriverManager.getConnection("jdbc:hive2://htsp.htdata.com:10000", "hive", "hive");
        Statement stmt = conn.createStatement();
        stmt.execute("ANALYZE TABLE default.test COMPUTE STATISTICS");
        List<String> logs = ((HiveStatement) stmt).getQueryLog();
        String log = logs.get(logs.size() - 1);

        Pattern p = Pattern.compile(".*?numRows=(\\d+).*?totalSize=(\\d+).*?");
        Matcher m = p.matcher(log);
        int rowNum = 0;
        int total = 0;
        if (m.find()) {
            rowNum = Integer.parseInt(m.group(1));
            total = Integer.parseInt(m.group(2));
        }
        System.out.println(rowNum);
        System.out.println(total);
    }
}
