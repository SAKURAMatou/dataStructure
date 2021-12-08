package com.dl.nowcoder.multithread;

import java.util.stream.IntStream;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-08 8:33
 */
public class ThreadPriority
{
    public static class T1 extends Thread
    {
        public void run() {
            System.out.println(String.format("当前线程名称为：%s,优先级为：%d", Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1(), "T_" + i);
            thread.setPriority(i);
            thread.start();
        });
    }
}
