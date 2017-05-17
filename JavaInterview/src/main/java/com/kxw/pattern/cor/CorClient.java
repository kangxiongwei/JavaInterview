package com.kxw.pattern.cor;

/**
 * Created by kangxiongwei3 on 2017/5/17 19:16.
 */
public class CorClient {

    public static void main(String[] args) {
        Handler handler = new EatHandler();
        do {
            handler.next();
            handler = handler.getHandler();
        }
        while (handler != null);
    }

}
