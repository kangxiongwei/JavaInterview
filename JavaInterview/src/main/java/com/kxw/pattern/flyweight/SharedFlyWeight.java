package com.kxw.pattern.flyweight;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:55.
 */
public class SharedFlyWeight implements FlyWeight {

    @Override
    public void put(String key, Object obj) {
        System.out.println("this is put method");
    }

    @Override
    public Object get(String key){
        System.out.println("this is get method");
        return null;
    }
}
