package com.aso.javabasis.handler;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消息队列的维护
 * Created by itsdf07 on 2017/6/21 15:38.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class MessageQueue {

    //互斥锁和条件变量
    Lock lock;
    Condition notEmpty;
    Condition notFulll;

    //存储消息列表
    Message[] items;
    int putIndex;//放进去的消息索引
    int takeIndex;//取出消息的索引
    int count;//消息总数


    public MessageQueue() {
        this.items = new Message[50];//消息是都发完了才进行处理的
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFulll = lock.newCondition();
    }

    /**
     * 入队：加入消息队列（生产者,子线程）
     *
     * @param msg
     */
    public void enqueueMessage(Message msg) {
        //当消息队列已满，停止消息加入，子线程阻塞
        try {
            lock.lock();
            while(count == items.length) {
                try {
                    notFulll.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            items[putIndex] = msg;
            putIndex = (++putIndex == items.length) ? 0 : putIndex;
            count++;
            notEmpty.signalAll();//通知消费者消费:可能唤醒同类
        } finally {
            lock.unlock();
        }

    }

    /**
     * 出队：弹出消息队列（消费者，主线程）
     *
     * @return
     */
    public Message next() {
        //当消息队列被掏空，主线程阻塞
        Message msg = null;
        try {
            lock.lock();
            while (count == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            msg = items[takeIndex];
            takeIndex = (++takeIndex == items.length) ? 0 : takeIndex;
            count--;
            notFulll.signalAll();//通知生产者可以生产:可能唤醒同类
        } finally {

        }

        return msg;
    }
}
