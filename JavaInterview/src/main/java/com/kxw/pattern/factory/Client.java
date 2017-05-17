package com.kxw.pattern.factory;

import com.kxw.pattern.factory.abs.AbstractFruitFactory;
import com.kxw.pattern.factory.abs.NorthFruitFactory;
import com.kxw.pattern.factory.abs.SouthFruitFactory;
import com.kxw.pattern.factory.simple.SimpleFruitFactory;

/**
 * Created by kangxiongwei3 on 2017/5/17 17:29.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        //简单工厂模式
        Fruit apple = SimpleFruitFactory.getFruit(Apple.class);
        System.out.println(apple.getFruitInfo());
        Fruit banana = SimpleFruitFactory.getFruit(Banana.class);
        System.out.println(banana.getFruitInfo());

        //抽象工厂模式
        AbstractFruitFactory northFruitFactory = new NorthFruitFactory();
        System.out.println("------北方工厂----------");
        northFruitFactory.getApple().say();
        northFruitFactory.getBanana().say();
        AbstractFruitFactory southFruitFactory = new SouthFruitFactory();
        System.out.println("--------南方工程--------");
        southFruitFactory.getApple().say();
        southFruitFactory.getBanana().say();
    }



}
