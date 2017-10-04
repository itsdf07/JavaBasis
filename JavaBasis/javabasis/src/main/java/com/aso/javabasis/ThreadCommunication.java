package com.aso.javabasis;

/**
 * 线程通讯：生产者、消费者概念(已有产品，通知消费者消费，消费者消费完之后，通知生产者生产)
 * <p>
 * 1、同步：本质上就是“共享内存”式的通信。多个线程需要访问同一个共享变量，谁拿到了锁（获得了访问权限），谁就可以执行。
 * 2、While轮询：浪费CPU资源，volatile关键字的可见性
 * 3、wait/notify机制：
 * 4、管道通信就是使用java.io.PipedInputStream 和 java.io.PipedOutputStream进行通信：
 * <p>
 * Created by itsdf07 on 2017/6/3 17:26.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class ThreadCommunication {

    public static void main(String[] arg) {
        Object lock = new Object();
        new Producer(lock).start();
        new Consumer(lock).start();
    }

    //

    /**
     * 产品
     */
    private static class ProductObject {
        /**
         * 关键字volatile：线程操作变量可见
         * PS：线程都是先把变量读取到本地线程栈空间，然后再去再去修改的本地变量。
         * 因此，如果线程B每次都在取本地的 条件变量，那么尽管另外一个线程已经改变了轮询的条件，
         * 它也察觉不到，这样也会造成死循环。
         */
        public volatile static String value;
    }

    /**
     * 生产者
     */
    private static class Producer extends Thread {
        Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {//互斥锁
                    //产品还没被消费掉，则等待消费
                    if (ProductObject.value != null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ProductObject.value = "NO:" + System.currentTimeMillis();
                    System.out.println("生产的产品：" + ProductObject.value);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();//产品生产完成了，通知消费者消费
                }
            }
        }
    }

    /**
     * 消费者
     */
    private static class Consumer extends Thread {
        Object lock;

        public Consumer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {//互斥锁
                    //还没有产品消费，等待生产者生产
                    if (ProductObject.value == null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费的产品：" + ProductObject.value);
                    ProductObject.value = null;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();//产品已经消费，通知生产者生产
                }
            }
        }
    }

}
