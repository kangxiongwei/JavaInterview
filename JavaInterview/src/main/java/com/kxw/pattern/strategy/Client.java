package com.kxw.pattern.strategy;

/**
 * Created by kangxiongwei on 2015/7/5.
 * 策略模式
 * <p>
 * 缺点：
 * 客户端必须知道所有的策略类，并自行决定使用哪种策略
 * 造成很多的策略类
 * <p>
 * 解决办法：工厂方法模式
 * <p>
 * 优点：
 */
public class Client {

    public static void main(String[] args) {
        Strategy strategy = new AddStrategy();
        Environment environment = new Environment(strategy);
        System.out.println(environment.calculate(3, 4));
    }

}
