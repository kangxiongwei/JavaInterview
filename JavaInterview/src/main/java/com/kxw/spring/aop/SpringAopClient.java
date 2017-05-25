package com.kxw.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kangxiongwei3 on 2017/5/25 10:21.
 */
public class SpringAopClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SpringAopInter aop = context.getBean("proxyFactoryBean", SpringAopInter.class);
        aop.testAop();
    }



}
