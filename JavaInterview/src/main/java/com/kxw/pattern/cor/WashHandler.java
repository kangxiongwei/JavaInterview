package com.kxw.pattern.cor;

/**
 * Created by kangxiongwei3 on 2017/5/17 19:16.
 */
public class WashHandler implements Handler {

    @Override
    public boolean next() {
        System.out.println("start wash");
        return true;
    }

    @Override
    public Handler getHandler() {
        return new SleepHandler();
    }
}
