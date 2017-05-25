package com.kxw.spring.aop;

import org.springframework.stereotype.Component;

/**
 * Aop的目标对象
 * Created by kangxiongwei3 on 2017/5/25 10:15.
 */
@Component
public class SpringAopTarget implements SpringAopInter{

    @Override
    public void testAop() {
        System.out.println("测试Spring的AOP功能");
    }


}
