package com.aso.javabasis.handler;

/**
 * Created by itsdf07 on 2017/6/21 15:38.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class Looper {

    MessageQueue mQueue;
    static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    /**
     * 初始化Looper对象
     * 一个线程只能管理一个Looper对象
     */
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    /**
     * 获取当前线程关联的Looper对象
     *
     * @return
     */
    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    /**
     * 轮询消息队列
     */
    public static void loop() {
        Looper looper = myLooper();
        MessageQueue queue = looper.mQueue;
        for (; ; ) {
            Message msg = queue.next();
            if (msg == null) {
                continue;
            }
            msg.target.dispatchMessage(msg);
        }


    }

    private Looper() {
        //一个looper对应一个MessageQueue，所以在这边实例
        mQueue = new MessageQueue();
    }

}
