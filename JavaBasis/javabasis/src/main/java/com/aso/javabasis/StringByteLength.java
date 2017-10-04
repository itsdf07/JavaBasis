package com.aso.javabasis;

import java.io.UnsupportedEncodingException;

/**
 * 关于java获取字节的长度.
 * Created by itsdf07 on 2017/10/4 13:15.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class StringByteLength {

    public static void main(String[] args) throws UnsupportedEncodingException {
        getStringByteLength("苏");
    }


    /**
     * 获取字符的所占字节长度;
     *
     * @param str
     * @throws UnsupportedEncodingException
     */
    public static void getStringByteLength(String str) throws UnsupportedEncodingException {
        System.out.println("\"" + str + "\"字符所占的字节长度如下:");
        System.out.println("ISO-8859-1:" + str.getBytes("ISO-8859-1").length);
        System.out.println("UTF-8:" + str.getBytes("UTF-8").length);
        System.out.println("GBK:" + str.getBytes("GBK").length);
        System.out.println("GB2312:" + str.getBytes("GB2312").length);
        System.out.println("GB18030:" + str.getBytes("GB18030").length);
        System.out.println("UTF-16:" + str.getBytes("UTF-16").length);
    }

}
