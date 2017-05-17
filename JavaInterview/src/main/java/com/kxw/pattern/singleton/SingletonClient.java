package com.kxw.pattern.singleton;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:01.
 */
public class SingletonClient {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1);
    }


}
