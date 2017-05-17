package com.kxw.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kangxiongwei on 2015/7/16.
 */
public class MyClient {

    public static void main(String[] args) {
        Observer observer1 = new MyObserver();
        Observer observer2 = new MyObserver2();

        MyObservable observable = new MyObservable();
        observable.addObserver(observer2);
        observable.addObserver(observer1);

        observable.count(10);
    }

}
