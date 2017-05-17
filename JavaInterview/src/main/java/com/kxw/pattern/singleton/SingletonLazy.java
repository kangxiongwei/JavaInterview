package com.kxw.pattern.singleton;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:02.
 */
public class SingletonLazy {

    private SingletonLazy lazy;

    private SingletonLazy() {
    }

    public SingletonLazy getInstance() {
        synchronized (SingletonLazy.class) {
            if (lazy == null) {
                lazy = new SingletonLazy();
            }
        }
        return lazy;
    }

}
