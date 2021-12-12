package com.dl.nowcoder.multithread;

import java.util.Date;

/**
 * @author DML
 * @descriptions线程的状态
 * @date 2021-12-12 16:27
 */
public class ThreadState
{
    public void stateNew() {
        Thread thread = new Thread(() -> {
        });
        System.out.println("NEW状态：" + thread.getState());

    }

    public static void main(String[] args) {
        //
        ThreadState threadState = new ThreadState();
        // threadState.stateNew();

        // 阻塞状态
        threadState.bolckTest();

    }

    public void bolckTest() {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run() {
                testMethod();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run() {
                testMethod();
            }
        }, "t2");
        t1.start();
        t2.start();
        Date start = new Date();
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());

    }

    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
