package com.kxw.designpattern.poxy.statics;

import com.kxw.designpattern.poxy.Action;

/**
 * 静态代理
 * Created by kangxiongwei3 on 2017/5/17 16:02.
 */
public class StaticsProxy implements Action {

    private Action target;

    public StaticsProxy(Action target) {
        this.target = target;
    }

    @Override
    public void execute(String command) {
        System.out.println("before the static proxy to execute command");
        this.target.execute(command);
        System.out.println("after the static proxy to execute command");
    }
}
