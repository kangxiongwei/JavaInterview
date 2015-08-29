package com.kxw.thread.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kangxiongwei on 2015/7/20.
 * 设计一个缓存系统
 */
public class CacheSystem {

    public static void main(String[] args) {

        CacheData cd = new CacheData();

        for (int i=0; i<3; i++) {
            new Thread(new CacheThread(cd)).start();
        }

    }

}

class CacheData {

    private Map<String,Object> map = new HashMap<String, Object>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object getData(String key) {
        readWriteLock.readLock().lock();
        Object obj = null;
        try {
            obj = map.get(key);
            while (obj == null) {
                //防止多次查询数据库，必须上写锁
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    obj = "abc"; //实际从数据库查询
                    Thread.sleep(1000);
                    map.put(key,obj);
                } finally {
                    readWriteLock.writeLock().unlock();
                    readWriteLock.readLock().lock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        return obj;
    }

}

class CacheThread implements Runnable{

    private CacheData cd;

    public CacheThread(CacheData cd){
        this.cd = cd;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            Object value = cd.getData("kang");
            System.out.println(Thread.currentThread().getName()+" get data: "+value);
        }
    }
}