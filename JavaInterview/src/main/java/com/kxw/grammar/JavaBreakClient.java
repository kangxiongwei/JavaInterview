package com.kxw.grammar;

/**
 * 测试一下循环中break、continue的作用
 * 类似于goto语句，ThreadPoolExecutor中使用到的
 * Create by kangxiongwei on 2018/1/22 14:24.
 */
public class JavaBreakClient {

    public static void main(String[] args) {
        invoke();
    }

    private static void invoke() {
        int i, j = 0;

        retry:
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 5; j++) {
                System.out.println("j = " + j);
                if (i == 1) continue retry; //重新执行一次内部循环
                if (i == 5 && j == 3) {
                    break retry; //跳出两层循环
                }
            }
        }

        System.out.println("i = " + i + ", j = " + j);

    }


}
