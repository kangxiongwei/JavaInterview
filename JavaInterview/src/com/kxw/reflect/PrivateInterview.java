package com.kxw.reflect;

import java.lang.reflect.Field;

/**
 * Created by kangxiongwei on 2015/6/19.
 * 通过反射来修改私有变量
 */
public class PrivateInterview {

    public static void main(String[] args) throws Exception{

        Person person = new Person();
        Class clazz = person.getClass();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"world");
        System.out.println(person.getName());

    }


}
