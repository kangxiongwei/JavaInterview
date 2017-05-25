package com.kxw.pattern.adaptor;

/**
 * Created by kangxiongwei3 on 2017/5/25 13:41.
 */
public class AdapterClient {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.say();
        target.eat();
    }



}
