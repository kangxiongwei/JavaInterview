package com.kxw.designpattern.observer;

import java.util.Observable;

/**
 * Created by kangxiongwei on 2015/7/16.
 */
public class MyObservable extends Observable {

    public void count(int number) {
        for (; number>=0; number--) {
            this.setChanged();
            this.notifyObservers(number);
        }
    }

}
