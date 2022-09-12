package com.dl.thread;

public class NoneLockDemo {

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(String.format("ThreadA执行%d", i));
            }
        }
    }
    public static class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(String.format("ThreadB执行%d", i));
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
