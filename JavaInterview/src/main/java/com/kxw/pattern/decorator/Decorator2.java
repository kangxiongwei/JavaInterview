package com.kxw.pattern.decorator;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:48.
 */
public class Decorator2 extends EnglishBookDecorator {

    @Override
    public void say() {
        System.out.println("this is decorator 2");
        super.say();
    }
}
