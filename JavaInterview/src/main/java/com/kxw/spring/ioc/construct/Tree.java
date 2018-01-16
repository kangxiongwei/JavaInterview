package com.kxw.spring.ioc.construct;

/**
 * Create by kangxiongwei on 2018/1/15 21:23.
 */
public class Tree {

    private String name;
    private String parent;

    public Tree(String name) {
        this.name = name;
    }

    public Tree(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }
}
