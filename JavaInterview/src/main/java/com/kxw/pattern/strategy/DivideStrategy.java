package com.kxw.pattern.strategy;

/**
 * Created by kangxiongwei on 2015/7/5.
 */
public class DivideStrategy implements Strategy {

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
