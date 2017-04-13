package com.joeykwok.haoqiuv2017.utils;

/**
 * Created by gjwlg on 2017/1/10.
 */

public class CommonUtils {

    public static String getDate(String time) {
        String year = time.substring(0, 4);
        String month = time.substring(5, 7);
        String day = time.substring(8, 10);
        return year + "年" + month + "月" + day + "日";
    }

    public static String getTime(String time) {
        return time.substring(11, 16);
    }
}
