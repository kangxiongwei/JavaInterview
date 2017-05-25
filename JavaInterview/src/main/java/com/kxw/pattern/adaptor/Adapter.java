package com.kxw.pattern.adaptor;

/**
 * 适配者
 *
 * Created by kangxiongwei3 on 2017/5/25 13:37.
 */
public class Adapter extends Adapted implements Target {

    /**
     * 通过适配者适配接口Target，保留了原来被适配类的say()，扩展了eat()
     */
    @Override
    public void eat() {
        System.out.println("I can eat");
    }
}
