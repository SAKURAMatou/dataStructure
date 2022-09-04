package com.dl.thread;

public class RunnableDemo {
    public static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("MyThread测试");
            Thread thread = Thread.currentThread();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
//        new Thread(()->{
//            System.out.println("测试函数式创建线程");
//        }).start();
        System.out.println("mian线程");
    }
}
