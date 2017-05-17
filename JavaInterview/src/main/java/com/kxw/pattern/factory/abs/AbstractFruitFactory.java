package com.kxw.pattern.factory.abs;

import com.kxw.pattern.factory.Fruit;

/**
 * Created by kangxiongwei3 on 2017/5/17 17:35.
 */
public interface AbstractFruitFactory {

    Apple getApple();

    Banana getBanana();

}
