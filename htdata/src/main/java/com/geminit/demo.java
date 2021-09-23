package com.geminit;


public class demo {
    public static void main(String[] args) throws Exception {
        char c = "谈游翔abc123!~./".charAt(3);
        String unicode = Integer.toHexString(c);
        System.out.println(String.format("%4s", unicode));
    }
}
