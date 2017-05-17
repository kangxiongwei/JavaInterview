package com.kxw.pattern.flyweight;

import java.util.HashMap;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:58.
 */
public class FlyWeightFactory {

    private static final HashMap<String, FlyWeight> pool = new HashMap<>();

    private FlyWeight flyWeight;

    public void setFlyWeight(FlyWeight flyWeight) {
        this.flyWeight = flyWeight;
    }

    /**
     * 获取元素
     *
     * @param key
     * @return
     */
    public FlyWeight getFlyWeight(String key) {
        FlyWeight fly = pool.get(key);
        if (fly == null) {
            fly = flyWeight;
            pool.put(key, fly);
        }
        return fly;
    }

}
