package com.aso.javabasis.handler;

/**
 * Created by itsdf07 on 2017/6/21 15:37.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class Handler {
    private MessageQueue mQueue;
    private Looper mLooper;

    public Handler() {
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

    /**
     * 消息发送
     *
     * @param msg
     */
    public void sendMseeage(Message msg) {
        msg.target = this;
        mQueue.enqueueMessage(msg);
    }

    /**
     * 消息转发
     *
     * @param msg
     */
    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    /**
     * 消息处理
     *
     * @param msg
     */
    public void handleMessage(Message msg) {

    }
}
