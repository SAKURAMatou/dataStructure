package com.dl.thread;

import java.util.concurrent.*;

public class CallableDemo {

    public static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            // 模拟计算需要一秒
            Thread.sleep(2000);
            return 2;
        }
    }

//    public static void main(String[] args) throws Exception {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Task task = new Task();
//        Future<Integer> res = executorService.submit(task);
//        // 注意调用get方法会阻塞当前线程，直到得到结果。
//        // 所以实际编码中建议使用可以设置超时时间的重载get方法
//        System.out.println(res.get());
//        System.out.println("mian线程");
//    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask futureTask = new FutureTask(new Task());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        System.out.println("mian线程" + futureTask.isDone());
    }
}
