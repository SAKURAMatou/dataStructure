package com.dl.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeDemo {
    private static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
//                PipedReader字符流操作，一次 处理一个字符
                while ((receive = reader.read()) != -1) {
//                    System.out.println("接收到数据开始读取");
                    System.out.print((char) receive);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class WriterThread implements Runnable {

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");

            try {
                writer.write("writer test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        //通过PipedWriter的connect关联读和写
        writer.connect(reader);
        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();

    }
}
