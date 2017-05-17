package com.kxw.pattern.decorator;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:49.
 */
public class DecoratorClient {

    public static void main(String[] args) {
        Book book = new EnglishBook();
        EnglishBookDecorator decorator = new Decorator1();
        decorator.setBook(book);
        decorator.say();

        System.out.println("--------------------");

        //
        decorator = new Decorator2();
        decorator.setBook(book);
        decorator.say();
    }


}
