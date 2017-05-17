package com.kxw.pattern.poxy.dynamic;

import com.kxw.pattern.poxy.Action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 * Created by kangxiongwei3 on 2017/5/17 15:37.
 */
public class DynamicProxy implements InvocationHandler {

    //被代理对象
    private Action target;

    public DynamicProxy(Action target) {
        this.target = target;
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    public Object getProxy() {
        ClassLoader loader = this.target.getClass().getClassLoader();
        Class[] interfaces = this.target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before execute target method");

        //执行原始方法
        method.invoke(target, args);

        System.out.println("after execute target method");

        return null;
    }
}
