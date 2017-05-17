package com.kxw.pattern.decorator;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:10.
 */
public class EnglishBook implements Book {
    @Override
    public void say() {
        System.out.println("I am an english book");
    }
}
