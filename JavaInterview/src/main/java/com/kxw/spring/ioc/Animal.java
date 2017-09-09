package com.kxw.spring.ioc;

/**
 * Created by kangxiongwei on 2017/6/14.
 */
public class Animal {

    private String name;
    private String src;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
