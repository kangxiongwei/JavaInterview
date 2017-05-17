package com.kxw.statics;

/**
 * Created by kangxiongwei on 2015/6/19.
 */
public class StaticInterview {

    private static StaticInterview staticInterview = new StaticInterview();

    private static int count1;
    private static int count2 = 0;

    public StaticInterview(){
        count1++;
        count2++;
    }

    public static void main(String[] args){
        System.out.println(StaticInterview.count1); //1
        System.out.println(StaticInterview.count2); //0  执行完构造方法后，变为1，但是之后，会被重新赋值，变成0
    }

}
