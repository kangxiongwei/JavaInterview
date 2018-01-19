package com.kxw.spring.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * Create by kangxiongwei on 2018/1/18 10:29.
 */
public class CountingAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object obj;
        System.out.println("环绕通知前");
        try {
            obj = invocation.proceed();
            System.out.println("环绕通知后");
        } catch (Throwable throwable) {
            System.out.println("环绕通知异常");
            throw throwable;
        } finally {
            System.out.println("环绕后置通知");
        }
        return obj;
    }

}
