package com.kxw.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 前置通知
 * Created by kangxiongwei3 on 2017/5/25 10:09.
 */
@Component
public class CountingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置计算方法执行次数");
    }
}
