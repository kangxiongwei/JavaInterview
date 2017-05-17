package com.kxw.pattern.cor;

/**
 * Created by kangxiongwei3 on 2017/5/17 19:15.
 */
public class EatHandler implements Handler{

    @Override
    public boolean next() {
        System.out.println("start eat");
        return true;
    }

    @Override
    public Handler getHandler() {
        return new WashHandler();
    }
}
