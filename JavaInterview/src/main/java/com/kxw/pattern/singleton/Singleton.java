package com.kxw.pattern.singleton;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:00.
 */
public class Singleton {

    private static final Singleton s = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return s;
    }

}
