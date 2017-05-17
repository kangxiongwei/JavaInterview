package com.kxw.pattern.decorator;

/**
 * Created by kangxiongwei3 on 2017/5/17 18:10.
 */
public abstract class EnglishBookDecorator implements Book {

    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void say() {
        this.book.say();
    }
}
