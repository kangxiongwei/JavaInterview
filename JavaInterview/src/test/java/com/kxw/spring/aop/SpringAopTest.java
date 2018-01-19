package com.kxw.spring.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by kangxiongwei on 2018/1/17 18:06.
 */
public class SpringAopTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("beans-aop.xml");
    }

    @Test
    public void testAop() throws Exception {
        SpringAopInter proxy = context.getBean("proxyFactoryBean", SpringAopInter.class);
        proxy.testAop();
    }

    @Test
    public void testAopBasedSchema() throws Exception {
        SpringAopInter aop = context.getBean("springAopTarget", SpringAopInter.class);
        //aop.testAop();
        System.out.println(aop.helloAop("aop")); ;
    }

    @Test
    public void testAopIntroduction() {
        SpringAopInter target = (SpringAopInter)context.getBean("springAopTarget");
        System.out.println(target.helloAop("introduction"));

        CountingIntroductionAdvice introduction = (CountingIntroductionAdvice) context.getBean("springAopTarget");
        introduction.introduction();
    }

}
