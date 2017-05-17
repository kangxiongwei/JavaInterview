package com.kxw.pattern.flyweight;

/**
 * Created by kangxiongwei3 on 2017/5/17 19:06.
 */
public class FlyWeightClient {

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight flyWeight = new SharedFlyWeight();

        factory.setFlyWeight(flyWeight);

        FlyWeight expect = factory.getFlyWeight("kang");

        System.out.println(expect == flyWeight);

        FlyWeight expect2 = factory.getFlyWeight("kang");
        System.out.println(expect == expect2);
    }


}
