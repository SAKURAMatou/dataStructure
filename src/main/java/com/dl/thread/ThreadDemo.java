package com.dl.thread;

public class ThreadDemo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread线程测试");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.start();
        System.out.println("mian线程");
    }
}
