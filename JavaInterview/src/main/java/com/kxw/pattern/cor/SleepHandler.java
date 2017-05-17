package com.kxw.pattern.cor;

/**
 * Created by kangxiongwei3 on 2017/5/17 19:23.
 */
public class SleepHandler implements Handler {
    @Override
    public boolean next() {
        System.out.println("start sleep");
        return true;
    }

    @Override
    public Handler getHandler() {
        return null;
    }
}
