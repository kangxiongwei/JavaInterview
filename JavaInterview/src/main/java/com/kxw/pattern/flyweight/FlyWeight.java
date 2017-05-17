package com.kxw.pattern.flyweight;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:54.
 */
public interface FlyWeight {

    void put(String key, Object obj);

    Object get(String key);


}
