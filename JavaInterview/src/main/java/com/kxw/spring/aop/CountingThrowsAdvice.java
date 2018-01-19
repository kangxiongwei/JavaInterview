package com.kxw.spring.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Create by kangxiongwei on 2018/1/17 20:09.
 */
public class CountingThrowsAdvice implements ThrowsAdvice {


    public void afterThrowing(Exception ex) {
        System.out.println("异常通知执行" + ex.getMessage());
    }


}
