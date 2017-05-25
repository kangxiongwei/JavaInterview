package com.kxw.spring.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 后置通知
 * Created by kangxiongwei3 on 2017/5/25 10:11.
 */
@Component
public class CountingAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置计算方法执行次数");
    }
}
