package com.ruoyi.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeTool {
    public static String parseUTCText(String text) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (text.indexOf(".") > -1) {
            String prefix = text.substring(0, text.indexOf("."));
            String suffix = text.substring(text.indexOf("."));
            if (suffix.length() >= 5) {
                suffix = suffix.substring(0, 4) + "Z";
            } else {
                int len = 5 - suffix.length();
                String temp = "";
                temp += suffix.substring(0, suffix.length() - 1);
                for (int i = 0; i < len; i++) {
                    temp += "0";
                }
                suffix = temp + "Z";
            }
            text = prefix + suffix;
        } else {
            text = text.substring(0, text.length() - 1) + ".000Z";
        }
        Date date = sdf.parse(text);
        return dateFormat.format(date);
    }
}
