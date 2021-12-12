package com.dl.nowcoder.multithread;

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
        // IntStream.range(1, 10).forEach(i -> {
        // Thread thread = new Thread(new T1(), "T_" + i);
        // thread.setPriority(i);
        // thread.start();
        // });
        // 线程组优先级和线程优先级
        // 线程优先级⼤于线程所在线程组的最⼤优先级，那么该线程的优先级将会失效，取⽽代之的是线程组的最⼤优先级
        // ThreadGroup group1 = new ThreadGroup("group1");
        // group1.setMaxPriority(6);
        // Thread t1 = new Thread(group1, "t1");
        // t1.setPriority(9);
        // System.out.println("线程组优先级" + group1.getMaxPriority());
        // System.out.println("线程优先级" + t1.getPriority());
        System.out.println("当前线程组名称" + Thread.currentThread().getThreadGroup().getName());
        // 复制线程组
        // Thread[] threads = new Thread[5];
        // ThreadGroup threadGroup = new ThreadGroup("g1");
        // threadGroup.enumerate(threads);

    }
}
