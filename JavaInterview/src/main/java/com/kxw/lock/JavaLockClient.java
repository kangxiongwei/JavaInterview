package com.kxw.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by kangxiongwei on 2018/1/19 15:16.
 */
public class JavaLockClient {

    private static Integer count = 0;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    public void decrease() {
        try {
            lock.lock();
            if (count > 0) count--;
        } finally {
            lock.unlock();
        }
    }

    public void increase() {
        try {
            lock.lock();
            if (count <= 10) count++;
        } finally {
            lock.unlock();
        }
    }


}
