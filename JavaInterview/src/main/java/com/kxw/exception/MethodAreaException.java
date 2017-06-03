package com.kxw.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池溢出
 *
 * JDK1.6前： -XX:PermSize=10m -XX:MaxPermSize=10m
 * JDK1.6后：
 *
 * Created by kangxiongwei on 2017/6/3.
 */
public class MethodAreaException {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        int i = 1;
//        for (;;) {
//            list.add(String.valueOf(i++).intern());
//        }

        StringBuilder builder = new StringBuilder("计算机");
        String str1 = builder.append("软件").toString();
        builder.append("sss");
        str1 = builder.toString();
        System.out.println(str1.intern() == str1);

//        while (true) {
//            builder.append("sdfsdfdf");
//            builder.toString();
//        }


        //System.out.println(str1.intern() == str1);

        //String str2 = new StringBuilder("ja").append("va").toString();
        //System.out.println(str2.intern() == str2);

    }



}
