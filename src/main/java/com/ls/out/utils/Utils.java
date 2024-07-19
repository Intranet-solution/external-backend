package com.ls.out.utils;

import java.sql.Date;
import java.time.LocalDate;

public class Utils {
    public static Date converterDate(LocalDate date) {
        if(date == null) return null;
        return java.sql.Date.valueOf(date);
    }
}
