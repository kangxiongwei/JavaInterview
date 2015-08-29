package com.kxw.thread.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kangxiongwei on 2015/7/20.
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {

        final MyQueue queue = new MyQueue();

        for (int i=0; i<3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10; i++) {
                        queue.read();
                    }
                }
            }).start();
        }

        for (int i=0; i<3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10; i++) {
                        queue.write();
                    }
                }
            }).start();
        }

    }

}

class MyQueue {

    private Object object;

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void read() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" be ready to read");
            Thread.sleep((long)Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+" have read data "+object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void write() {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" be ready to write");
            Integer data = new Random().nextInt(10000);
            this.object = data;
            Thread.sleep((long)Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+" have write data "+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

}
