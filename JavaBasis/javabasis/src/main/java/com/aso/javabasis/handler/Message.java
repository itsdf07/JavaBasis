package com.aso.javabasis.handler;

/**
 * Created by itsdf07 on 2017/6/21 16:25.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class Message {
    //目标Handler
    Handler target;

    public int what;
    public Object obj;

    @Override
    public String toString() {
        return obj.toString();
    }
}
