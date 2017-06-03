package com.kxw.exception;

/**
 * 栈内存溢出
 * <p>
 * -Xss256k
 * <p>
 * Created by kangxiongwei on 2017/6/3.
 */
public class StackOverflow {

    public static void main(String[] args) throws Exception {
        try {
            increase();
        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        }
    }

    static int i = 1;

    static void increase() {
        i++;
        increase();
    }


}
