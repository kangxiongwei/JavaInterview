package com.kxw.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * <p>
 * Created by kangxiongwei on 2017/6/3.
 */
public class HeapOutOfMemory {

    /**
     * VM参数  -Xmx3m -Xms3m -XX:+HeapDumpOnOutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        List<A> list = new ArrayList<>();
        System.setProperty("Xss", "256k");
        int i = 0;
        for (; ; ) {
            //list.add(new A());
            System.out.println(i++);
            Thread.sleep(1000);
        }
    }

    static class A {}

}
