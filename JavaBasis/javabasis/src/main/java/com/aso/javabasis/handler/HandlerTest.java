package com.aso.javabasis.handler;

import java.util.UUID;

/**
 * Created by itsdf07 on 2017/6/21 20:14.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class HandlerTest {
    public static void main(String[] args) {

        Looper.prepare();
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println(Thread.currentThread().getName() + ", received message : " + msg.toString());
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true){
                        Message msg = new Message();
                        synchronized (UUID.class){
                            msg.obj = UUID.randomUUID().toString();
                        }
                        System.out.println(Thread.currentThread().getName() + ", send message : " + msg);
                        handler.sendMseeage(msg);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        //主线程消息轮询
        Looper.loop();
    }
}
