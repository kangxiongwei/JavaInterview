package com.kxw.string;

/**
 * Created by kangxiongwei on 2015/6/19.
 */
public class StringInterview {

    public static void main(String[] args){

        String s1 = new String("abc"); //两个对象，一个在string pools中 一个在堆中
        String s2 = "abc";             //不创建对象 指向string pools中的"abc"对象
        String s3 = new String("abc"); //一个对象 堆中

        System.out.println(s1 == s2);  //false
        System.out.println(s1 == s3);  //false
        System.out.println(s2 == s3);  //false
        System.out.println("-----------------------------------");

        //intern() 如果string pools中包含内容 则返回string pools中的对象
        System.out.println(s1 == s1.intern());  //false
        System.out.println(s2 == s1.intern());  //true
        System.out.println(s1.intern() == s3.intern());  //true
        System.out.println("-----------------------------------");

        String hello = "hello";
        String hel = "hel";
        String lo = "lo";
        System.out.println(hello == "hel" + "lo"); //true  +号两边都是字符串，会先将字符串合起来，再到string pools中找
        System.out.println(hello == "hel" + lo); //false +号两边有一个是引用，则会在堆中创建对象
        System.out.println(hello == hel + lo);  //false

    }

}
