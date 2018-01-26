package com.kxw.string;

/**
 * Create by kangxiongwei on 2018/1/24 13:40.
 */
public class StringUpperTest {

    public static void main(String[] args) {
        String str = "fmn";
        String upper = str.toUpperCase();
        System.out.println(str);
        System.out.println(upper);

        String rep = str.replace('f', 'F');
        System.out.println(rep);
    }


}
