package com.kxw.thread.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kangxiongwei on 2015/7/20.
 */
public class ConditionTest {

    public static void main(String[] args) {
        ProducerAndCustomer pac = new ProducerAndCustomer();
        new Thread(new ProducerThread(pac)).start();
        new Thread(new CustomerThread(pac)).start();
        new Thread(new ProducerThread(pac)).start();
        new Thread(new CustomerThread(pac)).start();
    }

}

class ProducerAndCustomer {

    private int total;

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void product(){
        lock.lock();
        try {
            while (total != 0) {
                condition.await();
            }
            total++;
            System.out.println(Thread.currentThread().getName()+" : "+total);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void customer(){
        lock.lock();
        try {
            while (total == 0) {
                condition.await();
            }
            total--;
            System.out.println(Thread.currentThread().getName()+" : "+total);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ProducerThread implements Runnable{

    private ProducerAndCustomer pac;

    public ProducerThread(ProducerAndCustomer pac) {
        this.pac = pac;
    }

    @Override
    public void run() {
        /*for(int i=0; i<10; i++) {
            this.pac.product();
        }*/
        while (true) {
            this.pac.product();
        }
    }
}

class CustomerThread implements Runnable{

    private ProducerAndCustomer pac;

    public CustomerThread(ProducerAndCustomer pac) {
        this.pac = pac;
    }

    @Override
    public void run() {
        /*for(int i=0; i<10; i++) {
            this.pac.customer();
        }*/
        while (true) {
            this.pac.customer();
        }
    }
}