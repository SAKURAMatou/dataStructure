package com.dl.nowcoder.multithread;

/**
 * @author DML
 * @descriptions:多线程尝试
 * @date 2021-12-05 17:53
 */
public class DemoThread
{
    public static class MyThread extends Thread
    {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("多线程" + i+this.getName());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.start();
        myThread1.start();
    }
}
