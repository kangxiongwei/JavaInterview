package com.kxw.pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create by kangxiongwei on 2018/1/12 19:40.
 */
public class MapSingleton {

    private static final Map<String, Object> singletons = new ConcurrentHashMap<>();

    //私有构造函数
    private MapSingleton() {

    }

    /**
     * 外部调用获取实例的方法
     *
     * @return
     */
    public static MapSingleton getInstance() {
        if (singletons.get("key") == null) {
            singletons.put("key", new MapSingleton());
        }
        return (MapSingleton) singletons.get("key");
    }

    public static void main(String[] args) {
        MapSingleton singleton1 = getInstance();
        MapSingleton singleton2 = getInstance();

        System.out.println(singleton1 == singleton2);
    }

}
