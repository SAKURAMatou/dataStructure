package com.dl.thread;

public class ObjecLockDemo {

    private static Object lock = new Object();

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 30; i++) {
                    System.out.println(String.format("ThreadA执行%d", i));
                }
            }
        }
    }

    public static class ThreadB implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 30; i++) {
                    System.out.println(String.format("ThreadB执行%d", i));
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
//        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

}
