package com.kxw.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Create by kangxiongwei on 2018/1/18 11:55.
 */
public class SpringXmlAdvice {

    public void doBefore(JoinPoint jp) {
        System.out.println("前置通知");
    }

    public void doAfter(JoinPoint jp) {
        System.out.println("后置通知");
    }

    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知前");
        pjp.proceed();
        System.out.println("环绕通知后");
    }

}
