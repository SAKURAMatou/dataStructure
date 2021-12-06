package com.dl.nowcoder.multithread;

/**
 * @author DML
 * @descriptions
 * @date 2021-12-05 19:26
 */
public class Ticket
{
    public static class TicketOut implements Runnable
    {

        private int total;

        public TicketOut(int total) {
            this.total = total;
        }

        @Override
        public void run() {
            while (total > 0) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "抢到车票" + total--);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        //车票问题，没有锁的话，会同时操作同一个数据
        TicketOut ticketOut = new TicketOut(10);
        Thread t1 = new Thread(ticketOut, "小明");
        Thread t2 = new Thread(ticketOut, "黄牛");
        t1.start();
        t2.start();
    }
}
