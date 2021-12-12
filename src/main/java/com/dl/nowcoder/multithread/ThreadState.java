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

    public static void main(String[] args) throws InterruptedException {
        //
        ThreadState threadState = new ThreadState();
        // threadState.stateNew();

        // 阻塞状态
        threadState.bolckTest();

    }

    //线程由runnable状态进入waiting状态可通过Object.wait()，Thread.join()实现
    //调⽤join()⽅法不会释放锁，会⼀直等待当前线程执⾏完毕（转换为TERMINATED状态）
    //        t1.start();
    //        t1.join();
    //        t2.start();
    //t1和t2启动之间插入t1.join()的话，main线程启动t1之后会等t1线程结束之后再执行t2.start(),

    public void bolckTest() throws InterruptedException {
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
//        Thread.sleep(100);
        t1.join(3000L);
//        t1.wait();
        t2.start();
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
