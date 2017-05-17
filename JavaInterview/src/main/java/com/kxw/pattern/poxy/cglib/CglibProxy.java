package com.kxw.pattern.poxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用CGLIB实现动态代理
 * Created by kangxiongwei3 on 2017/5/17 16:11.
 */
public class CglibProxy implements MethodInterceptor {

    //CGLIB的操作类
    private Enhancer enhancer = new Enhancer();
    private CglibTarget target;

    public CglibProxy(CglibTarget target) {
        this.target = target;
    }


    public Object getProxy() {
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before use cglib proxy execute target method");

        //调用父类方法
        methodProxy.invokeSuper(o, objects);

        System.out.println("before use cglib proxy execute target method");

        return null;
    }
}
