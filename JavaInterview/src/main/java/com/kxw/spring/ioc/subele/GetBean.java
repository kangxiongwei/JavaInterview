package com.kxw.spring.ioc.subele;

/**
 * Create by kangxiongwei on 2018/1/15 14:34.
 */
public abstract class GetBean {

    public abstract Player getBean();

    public void who() {
        this.getBean().who();
    }

}
