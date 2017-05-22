package com.kxw.thread.aqs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 以下是一个非再进入的互斥锁类，
 * 它使用值 0 表示未锁定状态，使用 1 表示锁定状态。
 * 当非重入锁定不严格地需要当前拥有者线程的记录时，此类使得使用监视器更加方便。
 * Created by kangxiongwei3 on 2017/5/18 11:13.
 */
public class MutexLock implements Lock, Serializable {

    //由该类实现复杂的工作，外面只是调用它
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否独占模式，当锁定时，返回true，表示锁被占用
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 尝试获取锁，如果未被锁定，则当前线程获得锁并持有锁，否则返回false
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1; //
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            //不需要释放锁
            if (getState() == 0) throw new IllegalMonitorStateException();

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }

        /**
         * 反序列化
         *
         * @param s
         */
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0);
        }


    }

    private final Sync sync = new Sync();


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


}
