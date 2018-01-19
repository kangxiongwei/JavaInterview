package com.kxw.spring.aop;

/**
 * Create by kangxiongwei on 2018/1/18 19:31.
 */
public class CountingIntroductionAdviceImpl implements CountingIntroductionAdvice {

    private SpringAopInter springAopInter;

    @Override
    public void introduction() {
        System.out.println("引入通知");
    }

    public SpringAopInter getSpringAopInter() {
        return springAopInter;
    }

    public void setSpringAopInter(SpringAopInter springAopInter) {
        this.springAopInter = springAopInter;
    }
}
