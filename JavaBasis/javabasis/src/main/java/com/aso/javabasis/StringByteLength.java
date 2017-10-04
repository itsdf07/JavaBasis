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

//在Java中一共有8种基本数据类型，其中有4种整型，2种浮点类型，1种用于表示Unicode编码的字符单元的字符类型和1种用于表示真值的boolean类型。（一个字节等于8个bit）
//
//    1.整型
//    类型              存储需求     bit数    取值范围      备注
//    int               4字节       4*8
//    short             2字节       2*8     －32768～32767
//    long              8字节       8*8
//    byte              1字节       1*8     －128～127
//
//    2.浮点型
//    类型              存储需求     bit数    取值范围      备注
//    float             4字节       4*8                  float类型的数值有一个后缀F(例如：3.14F)
//    double            8字节       8*8                   没有后缀F的浮点数值(如3.14)默认为double类型
//
//    3.char类型
//    类型              存储需求     bit数     取值范围      备注
//    char              2字节          2*8
//
//    4.boolean类型
//    类型              存储需求     bit数      取值范围      备注
//    boolean          1字节        1*8       false、true

