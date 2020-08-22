package com.example.family.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static DateTimeFormatter formatter;
    static {
        formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static LocalDateTime getDateTime(){
        return LocalDateTime.now();
    }

    public static String getCurrentDateTime(){
        return LocalDateTime.now().format(formatter);
    }
}
