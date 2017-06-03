package com.kxw.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * 运行时异常，无需throws或者throw，可以直接被调用者捕获到
 * 非运行时异常，必须try...catch...或者throws，否则编译不能通过
 *
 * Created by kangxiongwei on 2017/6/3.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            runtimeException(null);
            //
            System.out.println("hello world");
        } catch (Exception e) {
            //e.printStackTrace();
        }
        System.out.println("hello ex");
    }


    private static boolean runtimeException(String s) {
        double a = Double.parseDouble(s);
        System.out.println("success");
        return true;
    }

    private static boolean unRuntimeException(String s) {
        File file = new File(s);
        try {
            FileInputStream in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


}
