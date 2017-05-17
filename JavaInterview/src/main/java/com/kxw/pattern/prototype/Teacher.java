package com.kxw.pattern.prototype;

import java.io.Serializable;

/**
 * Created by kangxiongwei on 2015/7/18.
 */
public class Teacher implements Cloneable,Serializable {

    private String name;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
