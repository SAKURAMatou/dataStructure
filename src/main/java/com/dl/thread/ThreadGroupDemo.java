package com.dl.thread;


import java.util.stream.IntStream;

public class ThreadGroupDemo {
    public static class ThreadPriorityTest extends Thread {
        @Override
        public void run() {
            System.out.println(String.format("当前执行的线程是%s,优先级是%d", Thread.currentThread().getName(), Thread.currentThread().getPriority()));
        }
    }

    /**
     * 线程的优先级不代表线程一定会被先执行
     * @param args
     */
//    public static void main(String[] args) {
//        IntStream.range(1, 10).forEach(i -> {
//            ThreadPriorityTest threadPriorityTest = new ThreadPriorityTest();
//            threadPriorityTest.setPriority(i);
//            threadPriorityTest.start();
//        });
//    }

    /**
     * 线程组的优先级和线程优先级冲突
     *
     * @param args
     */
//    public static void main(String[] args) {
//        ThreadGroup threadGroup = new ThreadGroup("dl");
//        threadGroup.setMaxPriority(6);
//        Thread thread = new Thread(threadGroup, new ThreadPriorityTest());
//        thread.setPriority(8);
//        System.out.println("线程组优先级"+threadGroup.getMaxPriority());
//        System.out.println("线程优先级"+thread.getPriority());
//    }

    /**
     * 线程组的异常处理
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadGroup exceptionTest = new ThreadGroup("exceptionTest") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("%s:%s", t.getName(), e.getMessage()));
            }
        };
        Thread test = new Thread(exceptionTest, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("异常测试");
            }
        });
        test.start();
    }
}
