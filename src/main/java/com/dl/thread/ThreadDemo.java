package com.dl.thread;

public class ThreadDemo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread线程测试");
        }
    }

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
////        myThread.start();
//        System.out.println("mian线程");
        /**
         * 不指定线程组时，创建的新线程和main同一个组
         */
        new Thread(() -> {
            System.out.println("*************");
            System.out.println(Thread.currentThread().getName() + ";" + Thread.currentThread().getThreadGroup().getName());
        }).start();
        System.out.println(Thread.currentThread().getName() + ";" + Thread.currentThread().getThreadGroup().getName());
    }
}
