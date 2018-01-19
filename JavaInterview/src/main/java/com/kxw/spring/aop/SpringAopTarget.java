package com.kxw.spring.aop;

/**
 * Aop的目标对象
 * Created by kangxiongwei3 on 2017/5/25 10:15.
 */
public class SpringAopTarget implements SpringAopInter {

    @Override
    public void testAop() throws Exception {
        System.out.println("测试Spring的AOP功能");
        int i = 1 / 1;
        System.out.println("计算结果是：" + i);
    }

    @Override
    public String helloAop(String name) {
        return "hello " + name;
    }
}
