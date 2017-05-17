package com.kxw.pattern.factory.simple;

import com.kxw.pattern.factory.Fruit;

/**
 * Created by kangxiongwei3 on 2017/5/17 17:26.
 */
public class SimpleFruitFactory {

    public static Fruit getFruit(Class<? extends Fruit> clazz) throws Exception {
        return clazz.newInstance();
    }


}
