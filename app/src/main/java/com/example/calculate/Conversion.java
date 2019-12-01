package com.example.calculate;

public class Conversion {

    //mm->cm
    public String mmTocm(double i) {
        double j = i / 10;
        String str = "" + j;
        return str;
    }

    public String mmTodm(double i) {
        double j = i / 100;
        String str = "" + j;
        return str;
    }

    public String mmTom(double i) {
        double j = i / 1000;
        String str = "" + j;
        return str;
    }

    public String mmTokm(double i) {
        double j = i / 1000000;
        String str = "" + j;
        return str;
    }

    public String cmTomm(double i) {
        double j = i * 10;
        String str = "" + j;
        return str;
    }

    public String cmTodm(double i) {
        double j = i / 10;
        String str = "" + j;
        return str;
    }

    public String cmTom(double i) {
        double j = i / 100;
        String str = "" + j;
        return str;
    }

    public String cmTokm(double i) {
        double j = i / 1000;
        String str = "" + j;
        return str;
    }

    public String dmTomm(double i) {
        double j = i * 100;
        String str = "" + j;
        return str;
    }

    public String dmTocm(double i) {
        double j = i * 10;
        String str = "" + j;
        return str;
    }

    public String dmTom(double i) {
        double j = i / 10;
        String str = "" + j;
        return str;
    }

    public String dmTokm(double i) {
        double j = i / 100;
        String str = "" + j;
        return str;
    }

    public String mTomm(double i) {
        double j = i / 1000;
        String str = "" + j;
        return str;
    }

    public String mTocm(double i) {
        double j = i * 100;
        String str = "" + j;
        return str;
    }

    public String mTodm(double i) {
        double j = i * 10;
        String str = "" + j;
        return str;
    }

    public String mTokm(double i) {
        double j = i / 1000;
        String str = "" + j;
        return str;
    }

    public String kmTomm(double i) {
        double j = i * 1000000;
        String str = "" + j;
        return str;
    }

    public String kmTocm(double i) {
        double j = i * 100000;
        String str = "" + j;
        return str;
    }

    public String kmTodm(double i) {
        double j = i * 10000;
        String str = "" + j;
        return str;
    }

    public String kmTom(double i) {
        double j = i * 1000;
        String str = "" + j;
        return str;
    }

    public String mm2Tocm2(double i) {
        double j = i / 100;
        String str = "" + j;
        return str;
    }

    public String mm2Todm2(double i) {
        double j = i / 10000;
        String str = "" + j;
        return str;
    }

    public String mm2Tom2(double i) {
        double j = i / 1000000;
        String str = "" + j;
        return str;
    }

    public String mm2Tokm2(double i) {
        double j = i / Math.pow(10, -12);
        String str = "" + j;
        return str;
    }

    public String cm2Tomm2(double i) {
        double j = i * 100;
        String str = "" + j;
        return str;
    }

    public String cm2Todm2(double i) {
        double j = i / 100;
        String str = "" + j;
        return str;
    }

    public String cm2Tom2(double i) {
        double j = i / 10000;
        String str = "" + j;
        return str;
    }

    public String cm2Tokm2(double i) {
        double j = i / 1000000;
        String str = "" + j;
        return str;
    }

    public String dm2Tomm2(double i) {
        double j = i * Math.pow(10, 4);
        String str = "" + j;
        return str;
    }

    public String dm2Tocm2(double i) {
        double j = i * Math.pow(10, 2);
        String str = "" + j;
        return str;
    }

    public String dm2Tom2(double i) {
        double j = i * Math.pow(10, -2);
        String str = "" + j;
        return str;
    }

    public String dm2Tokm2(double i) {
        double j = i * Math.pow(10, -5);
        String str = "" + j;
        return str;
    }

    public String m2Tomm2(double i) {
        double j = i * Math.pow(10, 6);
        String str = "" + j;
        return str;
    }

    public String m2Tocm2(double i) {
        double j = i * Math.pow(10, 4);
        String str = "" + j;
        return str;
    }

    public String m2Todm2(double i) {
        double j = i * Math.pow(10, 2);
        String str = "" + j;
        return str;
    }

    public String m2Tokm2(double i) {
        double j = i * Math.pow(10, -6);
        String str = "" + j;
        return str;
    }

    public String km2Tomm2(double i) {
        double j = i * Math.pow(10, 12);
        String str = "" + j;
        return str;
    }

    public String km2Tocm2(double i) {
        double j = i * Math.pow(10, 10);
        String str = "" + j;
        return str;
    }

    public String km2Todm2(double i) {
        double j = i * Math.pow(10, 8);
        String str = "" + j;
        return str;
    }

    public String km2Tom2(double i) {
        double j = i * Math.pow(10, 6);
        String str = "" + j;
        return str;
    }

    public String twoToEight(String i) {
        String b;
        int a = Integer.parseInt(i, 2);//二进制转换为十进制
        b = Integer.toOctalString(a);//十进制转换为八进制
        return b;
    }

    public String twoToTen(String i) {
        int a = Integer.parseInt(i, 2);//二进制转换为十进制
        String str = "" + a;
        return str;
    }

    public String twoToSixteen(String i) {
        int a = Integer.parseInt(i, 2);//二进制转换为十进制
        String str = Integer.toHexString(a);//十进制转换为十六进制
        return str;
    }

    public String eightToTwo(String i) {
        int a = Integer.parseInt(i, 8);//八进制转换为十进制
        String str = Integer.toBinaryString(a);//十进制转换为二进制
        return str;
    }

    public String eightToTen(String i) {
        int a = Integer.parseInt(i, 8);//八进制转换为十进制
        return "" + a;
    }

    public String eightToSixteen(String i) {
        int a = Integer.parseInt(i, 8);//八进制转换为十进制
        String str = Integer.toHexString(a);//十进制转换为十六进制
        return str;
    }

    public String TenToTwo(String i) {
        int a = Integer.parseInt(i);
        String str = Integer.toBinaryString(a);//十进制转换为二进制
        return str;
    }

    public String TenToEight(String i) {
        int a = Integer.parseInt(i);
        String str = Integer.toOctalString(a);//十进制转换为八进制
        return str;
    }

    public String TenToSixteen(String i) {
        int a = Integer.parseInt(i);
        String str = Integer.toHexString(a);//十进制转换为十六进制
        return str;
    }

    public String SixteenToTwo(String i) {
        int a = Integer.parseInt(i, 16);//十六进制转换为十进制
        String str = Integer.toBinaryString(a);
        return str;
    }

    public String SixteenToEight(String i) {
        int a = Integer.parseInt(i, 16);//十六进制转换为十进制
        String str = Integer.toOctalString(a);
        return str;
    }

    public String SixteenToTen(String i) {
        int a = Integer.parseInt(i, 16);//十六进制转换为十进制
        return "" + a;
    }
}
