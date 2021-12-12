package com.dl.nowcoder.multithread;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-06 18:56
 */
public class ThreadGruopTest
{
    // public static void main(String[] args) {
    // // 创建一个线程查看线程组，线程名
    // new Thread(() -> {
    // System.out.println("当前线程名字" + Thread.currentThread().getName());
    // System.out.println("当前线程组名字" +
    // Thread.currentThread().getThreadGroup().getName());
    // }).start();
    // // 查看mian函数的线程组，线程名
    // System.out.println("main方法的线程组" +
    // Thread.currentThread().getThreadGroup().getName());
    // System.out.println("main方法的线程" + Thread.currentThread().getName());
    // }

    // 线程组的异常统一处理
    public static void main(String[] args) {

        ThreadGroup exception = new ThreadGroup("exception")
        {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // super.uncaughtException(t, e);
                System.out.println(t.getName() + e.getMessage());
            }
        };

        // thread创建包含线程组的线程时需要传入threadgroup，和runnable的实现
        Thread thread = new Thread(exception, new Runnable()
        {

            @Override
            public void run() {
                throw new RuntimeException("抛出异常");
            }
        });
        thread.start();

        Thread thread1 = new Thread(exception, () -> {
            throw new RuntimeException("抛出异常!");
        });
        thread1.start();
    }

}
