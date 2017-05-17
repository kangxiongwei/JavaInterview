package com.kxw.designpattern.poxy;

import com.kxw.designpattern.poxy.dynamic.DynamicProxy;
import com.kxw.designpattern.poxy.statics.StaticsProxy;

/**
 * 客户端
 * Created by kangxiongwei3 on 2017/5/17 15:45.
 */
public class Client {

    public static void main(String[] args) {
        Action target = new Target();

        String command = "hello proxy";

        //静态代理
        StaticsProxy staticsProxy = new StaticsProxy(target);
        staticsProxy.execute(command);

        //基于JDK的动态代理
        DynamicProxy proxy = new DynamicProxy(target);
        Action targetProxy = (Action) proxy.getProxy();
        targetProxy.execute(command);
    }




}
