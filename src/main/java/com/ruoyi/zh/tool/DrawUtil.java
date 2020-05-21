package com.ruoyi.zh.tool;

import java.text.DecimalFormat;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/5/13 15:40
 * @Version 1.0
 */
public class DrawUtil {
    /** 地球半径 米**/
    private static final double R = 6371e3;

    /** 地球半径 千米**/
    private static double EARTH_RADIUS = 6371.393;
    /** 180° **/
    private static final DecimalFormat df = new DecimalFormat("0.000000");

    /**
     * 根据一点的坐标与距离，以及方向，计算另外一点的位置
     * @param angle 角度，从正北顺时针方向开始计算
     * @param startLong 起始点经度
     * @param startLat 起始点纬度
     * @param distance 距离，单位m
     * @return
     */
    public static String[] calLocationByDistanceAndLocationAndDirection(double startLong,double startLat,double angle, double distance){
        String[] result = new String[2];
        //将距离转换成经度的计算公式
        double δ = distance/R;
        // 转换为radian，否则结果会不正确
        angle = Math.toRadians(angle);
        startLong = Math.toRadians(startLong);
        startLat = Math.toRadians(startLat);
        double lat = Math.asin(Math.sin(startLat)*Math.cos(δ)+Math.cos(startLat)*Math.sin(δ)*Math.cos(angle));
        double lon = startLong + Math.atan2(Math.sin(angle)*Math.sin(δ)*Math.cos(startLat),Math.cos(δ)-Math.sin(startLat)*Math.sin(lat));
        // 转为正常的10进制经纬度
        lon = Math.toDegrees(lon);
        lat = Math.toDegrees(lat);
        result[0] = df.format(lon);
        result[1] = df.format(lat);
        return result;
    }

    //角度 转换 弧度
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 米
     */
    public static double GetDistance(double lng1, double lat1, double lng2, double lat2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.abs(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }

    /**
     *
     * @param x1 起点经度
     * @param y1 起点纬度
     * @param x2 终点经度
     * @param y2 终点纬度
     * @return
     */
    public static double getRadian(double x1, double y1, double x2, double y2) {
        double dRotateAngle = Math.atan2(Math.abs(x1 - x2), Math.abs(y1 - y2));
        if (x2 >= x1) {
            if (y2 >= y1) {
            } else {
                dRotateAngle = Math.PI - dRotateAngle;
            }
        } else {
            if (y2 >= y1) {
                dRotateAngle = 2 * Math.PI - dRotateAngle;
            } else {
                dRotateAngle = Math.PI + dRotateAngle;
            }
        }
        dRotateAngle = (dRotateAngle * 180) / Math.PI;
        return dRotateAngle;
    }

    public static double getK(double x1, double y1, double x2, double y2){
        return (y1-y2)/(x1-x2);
    }

    public static double getB(double x1, double y1, double x2, double y2){
        double k=getK(x1,y1,x2,y2);
        double b=y1-k*x1;
        return b;
    }
    public static double getYByX(double k,double b,double x1){
        return x1*k+b;
    }


    public static void main(String[] args) {
//        String[] result = calLocationByDistanceAndLocationAndDirection(0,119.010212,32.147982, 100);
//        String[] result2 = calLocationByDistanceAndLocationAndDirection(90,119.010212,32.147982, 100);
//        String[] result3 = calLocationByDistanceAndLocationAndDirection(180,119.010212,32.147982, 100);
//        System.out.print(result[0]+",");
//        System.out.println(result[1]);
//        System.out.print(result2[0]+",");
//        System.out.println(result2[1]);
//        System.out.print(result3[0]+",");
//        System.out.println(result3[1]);
//        System.out.println(GetDistance(113.5949783333333,23.20435,113.5844433333333,23.200555));
        boolean dsaf=false||true;
        System.out.println(dsaf);
        double y1=113.918;
        double x1=35.3051;

        double y2=113.919;
        double x2=35.3055;

        double k=getK(x1,y1,x2,y2);
        double b=getB(x1,y1,x2,y2);

        int size=3;
        double d = (x2 - x1) / 4;
        for (int i = 1; i <= size; i++) {
            double x=x1+d*i;
            double y=getYByX(k,b,x);
            System.out.println(x+":"+y);
        }
    }
}
