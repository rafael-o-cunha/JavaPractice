package com.example.util;

public class SqlLogger {

    public static long initLog(String sql) {
        long start = System.currentTimeMillis();
        System.out.println(sql);
        return start;
    }

    public static void finishLog(long start) {
        long end = System.currentTimeMillis();
        System.out.println( "Execution time: " + (end - start) + "ms" );
    }
}