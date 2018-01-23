package com.kxw.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用阻塞队列实现一个生产者-消费者模型
 * 1.当队列为空，则需要生产者生产数据到队列中
 * 2.当队列不为空，则消费者可以从队列中取数据消费
 * 3.需要用到阻塞方法take()和put()
 * Create by kangxiongwei on 2018/1/22 15:12.
 */
public class BlockingQueueTest {


    public static void main(String[] args) {
        BlockingQueue<Product> queue = new ArrayBlockingQueue<>(100);
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

    static class Product {
        private String name;

        public Product(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    static class Producer implements Runnable {

        private BlockingQueue<Product> queue;
        private int count;

        Producer(BlockingQueue<Product> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (count <= 10) {
                try {
                    queue.put(new Product("product" + (count ++)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer implements Runnable {

        private BlockingQueue<Product> queue;

        Consumer(BlockingQueue<Product> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Product product = queue.take();
                    System.out.println(Thread.currentThread().getName() + "消费了" + product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
