package com.dl.nowcoder.multithread;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-05 18:08
 */
public class DemoRunnable
{
    public static class MyThread implements Runnable
    {

        @Override
        public void run() {
            System.out.println("多线程");
        }
    }

    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(()->{
            System.out.println("多线程-匿名内部类");
        }).start();
    }
}
