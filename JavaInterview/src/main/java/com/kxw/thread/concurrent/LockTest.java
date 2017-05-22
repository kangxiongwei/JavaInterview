package com.kxw.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kangxiongwei on 2015/7/20.
 */
public class LockTest {

    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(new BankThread(bank)).start();
        new Thread(new BankThread(bank)).start();
    }

}

class Bank {

    private int money = 1000;
    Lock lock = new ReentrantLock(true);

    /**
     * 取钱
     * @param number
     * @return
     */
    public int getMoney(int number) {
        lock.lock();
        try {
            if(number < 0) {
                return -1;
            } else if (number > money) {
                return -2;
            } else if (money < 0) {
                return -3;
            } else {
                Thread.sleep(1000);
                money -= number;
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return number;
    }

    public int getMoney(){
        return money;
    }
}

class BankThread implements Runnable {

    private Bank bank;

    public BankThread(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("[取到了]："+bank.getMoney(800));
        System.out.println("[还剩余]："+bank.getMoney());
    }
}