package com.kxw.designpattern.poxy;

/**
 * 被代理类
 * Created by kangxiongwei3 on 2017/5/17 15:38.
 */
public class Target implements Action {

    @Override
    public void execute(String command) {
        System.out.println("I am target and my command is " + command);
    }

}
