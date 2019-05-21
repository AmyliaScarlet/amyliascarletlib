package com.amyliascarlet.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date getDate(String toString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(toString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
