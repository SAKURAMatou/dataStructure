package com.dl.nowcoder.multithread;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-06 18:56
 */
public class ThreadGruopTest
{
    public static void main(String[] args) {
        // 创建一个线程查看线程组，线程名
        new Thread(() -> {
            System.out.println("当前线程名字" + Thread.currentThread().getName());
            System.out.println("当前线程组名字" + Thread.currentThread().getThreadGroup().getName());
        }).start();
        // 查看mian函数的线程组，线程名
        System.out.println("main方法的线程组" + Thread.currentThread().getThreadGroup().getName());
        System.out.println("main方法的线程" + Thread.currentThread().getName());
    }
}
