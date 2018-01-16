package com.kxw.spring.ioc.subele;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Create by kangxiongwei on 2018/1/15 14:38.
 */
public class Yao implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("I am YaoMing");
        return null;
    }
}
