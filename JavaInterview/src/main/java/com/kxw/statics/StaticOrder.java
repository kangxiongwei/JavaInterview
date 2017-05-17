package com.kxw.statics;

/**
 * Created by kangxiongwei on 2015/6/19.
 * 静态代码块的运行顺序
 */
public class StaticOrder {

    public static void main(String[] args){
        new Child();
        //结果为：
        /*This is parent static block
        This is child static block
        This is parent constructor
        This is child constructor*/
    }

}

class Parent{

    static String parentName = "parent";

    static {
        System.out.println("This is parent static block");
    }

    public Parent(){
        System.out.println("This is parent constructor");
    }
}
class Child extends Parent{

    static String childName = "child";

    static {
        System.out.println("This is child static block");
    }

    public Child(){
        System.out.println("This is child constructor");
    }
}