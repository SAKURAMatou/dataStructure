package com.dl.thread;

public class ThreadStatusDemo {
    /**
     * 线程的NEW RUNNABLE状态
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            System.out.println("线程启动");
//            System.out.println(Thread.currentThread().getState());
//        });
//        System.out.println("线程状态：" + thread.getState());
//        thread.start();
//    }

    /**
     * 线程状态转化，join进入等待状态
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            testMethod();
        }, "t1");
        Thread t2 = new Thread(() -> {
            testMethod();
        }, "t2");
        t1.start();
        t1.join();
//        Thread.sleep(1);
        t2.start();
        System.out.println(t1.getName() + ":" + t1.getState()); // 输出？
        System.out.println(t2.getName() + ":" + t2.getState());
    }

    public static synchronized void testMethod() {
        try {
            Thread.sleep(2000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
