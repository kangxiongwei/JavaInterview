package com.kxw.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kangxiongwei on 2015/7/16.
 */
public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
