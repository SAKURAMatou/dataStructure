# 进程与线程基本概念

进程：应⽤程序在内存中分配的空间，也就是正在运⾏的程序 。

线程：让⼀个线程执⾏⼀个子任务，这样⼀个进程就包含了多个线程，每个线程负责⼀个单独的子任务。

进程使操作系统的并发成为可能，线程让进程内部并发成为可能。通过进程也能实现并发，为什么要使用多线程实现并发呢？

- 进程之间的通信比较复杂（涉及操作系统），而线程之间的通信比较简单，通过共享资源即可在多线程之间实现通信。

- 进程是重量级的概念，线程是轻量级，对系统资源消耗较小



区别

进程是一个独立运行的环境，而线程是进程中执行的一个任务；本质区别在于**是否单独占有内存地址空间及其他系统资源（比如i/o）**

- 进程单独占有一定的内存地址空间，所以进程之间存在内存隔离，数据是分开的，数据共享复杂，但同步简单，每个进程之间互不干扰；线程是进程内部的概念，共享进程占有的地址空间和资源。数据共享简单，同步复杂。
- 一个进程单独占有内存地址，出现问题时不会影响其他进程、主程序，稳定性可靠性高；一个线程崩溃可能影响整个程序的稳定性，可靠性低
- 进程占有单独的内存地址空间，进程的创建和销毁不仅需要寄存器和栈信息，还需要资源的分配回收以及页调度，开销大；线程只需要保存寄存器和栈信息，开销较小；

进程是操作系统进行资源分配的基本单位，而线程是进行调度的基本单位，级CPU分配时间的单位。

# java多线程入门

## Thread类和Runnable接⼝  

### 继承Thread类

继承Thread

重写run方法

通过start启动线程

```java
public class Demo
{
    public static class MyThread extends Thread
    {
        @Override
        public void run() {
            System.out.println("多线程" + this.getName());
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.start();
        myThread1.start();
    }
}
#输出
多线程Thread-0
多线程Thread-1
```

调用start方法之后才算启动多线程

### 实现Runnable接口

创建Runnable的实现类

重写run方法

将线程丢入runnable实现类，调用start启动线程

```java
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
```

Runnable接口有@FunctionalInterface注解，说明可以使用函数式编程的方式；

实现Runnable避免了java的单继承

### Thread类常用方法

- currentThread()：静态⽅法，返回对当前正在执⾏的线程对象的引⽤；
- start()：开始执⾏线程的⽅法，java虚拟机会调⽤线程内的run()⽅法；
- yield()：yield在英语⾥有放弃的意思，同样，这⾥的yield()指的是当前线程愿意让出对当前处理器的占⽤。这⾥需要注意的是，就算当前线程调⽤了yield()⽅法，程序在调度的时候，也还有可能继续运⾏这个线程。
- sleep()：静态⽅法，使当前线程睡眠⼀段时间； 
- join()：使当前线程等待另⼀个线程执⾏完毕之后再继续执⾏，内部调⽤的是
  Object类的wait⽅法实现的；   





## Callable接口及future 接口

Callable接口定义了方法**public T call() throws Exception**。我们可以在Callable实现中声明强类型的返回值，甚至是抛出异常；

当你提交一个Callable对象给线程池时，将得到一个Future对象，并且它和你传入的Callable有相同的结果类型声明

```java
ExecutorService executorService = Executors.newCachedThreadPool();
        MyCallAble myCallAble = new MyCallAble();
        Future submit = executorService.submit(myCallAble);
```

Callable运行的线程将结果返回给主线程缓存起来，

### future 接口

```java
public abstract interface Future<V> {
	public abstract boolean cancel(boolean paramBoolean);
	public abstract boolean isCancelled();
	public abstract boolean isDone();
	public abstract V get() throws InterruptedException, ExecutionException;
	public abstract V get(long paramLong, TimeUnit paramTimeUnit)throws InterruptedException, ExecutionException, TimeoutException;
}
```

cancel方法，尝试取消线程的执行，不一定成功取消（已执行完，已取消，以及其他因素），返回取消线程执行的结果；入参表示是否使用中断方式取消线程

### FutureTask类  

FutureTask 是实现的 RunnableFuture 接⼝的，而RunnableFuture 接⼝同时继承了 Runnable 接⼝和 Future 接⼝  

```java
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
```



# 线程组、线程优先级

Java中⽤ThreadGroup来表示线程组，我们可以使⽤线程组对线程进⾏批量控制。

每个Thread必然存在于⼀个ThreadGroup中，Thread不能独⽴于ThreadGroup存在

### 线程优先级

java中线程优先级可以分为1-10默认为5；java的线程优先级是参考，最终由操作系统决定线程的优先级。

通过Thread的setPriority() ，getPriority()方法可以设置查看优先级

```java
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
某次输出
当前线程名称为：T_4,优先级为：4
当前线程名称为：T_3,优先级为：3
当前线程名称为：T_1,优先级为：1
当前线程名称为：T_9,优先级为：9
当前线程名称为：T_5,优先级为：5
当前线程名称为：T_6,优先级为：6
当前线程名称为：T_8,优先级为：8
当前线程名称为：T_2,优先级为：2
当前线程名称为：T_7,优先级为：7
```

java的线程调度采用**抢占式**-先到先得；通过线程调度器监控处于runnable状态的线程；默认的主线程是jvm启动的第一个main。

守护线程Daemon；默认的优先级低的线程；所有的非守护线程关闭时守护线程也会关闭

线程优先级⼤于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取⽽代之的是线程组的最大优先级

```java
ThreadGroup group1 = new ThreadGroup("group1");
group1.setMaxPriority(6);
Thread t1 = new Thread(group1, "t1");
t1.setPriority(9);
System.out.println("线程组优先级" + group1.getMaxPriority());
System.out.println("线程优先级" + t1.getPriority());
输出
线程组优先级6
线程优先级6
```

### 线程组

获取当前线程组名称

```
Thread.currentThread().getThreadGroup().getName()
```

线程组的统一异常处理

重写ThreadGroup的uncaughtException方法

```java
public static void main(String[] args) {

        ThreadGroup exception = new ThreadGroup("exception")
        {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // super.uncaughtException(t, e);
                System.out.println(t.getName() + e.getMessage());
            }
        };

        Thread thread = new Thread(exception, new Runnable()
        {

            @Override
            public void run() {
                throw new RuntimeException("抛出异常");
            }
        });
        thread.start();
    }
输出：Thread-0抛出异常
```

线程组是⼀个树状的结构，每个线程组下面可以有多个线程或者线程组。线程组可以起到统⼀控制线程的优先级和检查线程的权限的作用

# 线程的状态

```java
public enum State
    {
        NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED;
    }
```

## NEW

创建了，但没有执行start方法时的状态

```java
 Thread thread = new Thread(() -> {
        });
 System.out.println("NEW状态："+thread.getState());
```

在调用⼀次start()之后，threadStatus的值会改变（threadStatus !=0），此时再次调用start()⽅法会抛出  

## RUNNABLE  

RUNNABLE  表示线程正在运行；是jvm中的状态，Java线程的RUNNABLE状态其实是包括了传统操作系统线程的ready和running两个状态的。

## BLOCKED  

阻塞状态。处于BLOCKED状态的线程正等待锁的释放以进⼊同步区  

## WAITING  

等待状态。处于等待状态的线程变成RUNNABLE状态需要其他线程唤醒  

- Object.wait()：使当前线程处于等待状态直到另⼀个线程唤醒它；
- Thread.join()：等待线程执⾏完毕，底层调⽤的是Object实例的wait⽅法；
- LockSupport.park()：除⾮获得调⽤许可，否则禁⽤当前线程进⾏线程调度。  

## TIMED_WAITING  

超时等待状态。线程等待⼀个具体的时间，时间到后会被自动唤醒  

调⽤如下⽅法会使线程进⼊超时等待状态：

- Thread.sleep(long millis)：使当前线程睡眠指定时间；
- Object.wait(long timeout)：线程休眠指定时间，等待期间可以通过notify()/notifyAll()唤醒；
- Object.wait(long timeout)：线程休眠指定时间，等待期间可以通过notify()/notifyAll()唤醒；
- LockSupport.parkNanos(long nanos)： 除⾮获得调⽤许可，否则禁⽤当前线程进⾏线程调度指定时间；
- LockSupport.parkUntil(long deadline)：同上，也是禁⽌线程进⾏调度指定时间

## TERMINATED  

终⽌状态。此时线程已执⾏完毕

## 线程状态的转化