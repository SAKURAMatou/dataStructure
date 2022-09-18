package com.dl.thread;

public class Singleton {
    private static Singleton instance;

    /**
     * 双重锁检验实现单例模式
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Singleton.getInstance());
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Singleton.getInstance());
        });
        t1.start();
        t2.start();
    }
}
