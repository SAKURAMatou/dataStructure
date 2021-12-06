package com.dl.nowcoder.multithread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-05 19:46
 */
public class DemoCallable
{
    // 1、实现callable接口
    // 2、重写call方法，需要抛出异常
    // 3、创建目标对象
    // 4、创建执行服务
    // 5、提交执行结果
    // 6、获取结果
    // 7、关闭服务
    public static class MyCallAble implements Callable
    {

        @Override
        public Object call() throws Exception {
            Random random = new Random();
            int i = random.nextInt(5);
            Thread.sleep(2000 * i);
            return i;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyCallAble myCallAble = new MyCallAble();
        // 使用Future
        Future submit = executorService.submit(myCallAble);
        System.out.println(submit.get());
        // 使用
        FutureTask futureTask = new FutureTask<>(myCallAble);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        // 关闭线程池
        executorService.shutdown();
    }
}
