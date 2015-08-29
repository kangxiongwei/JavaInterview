package com.kxw.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kangxiongwei on 2015/7/16.
 */
public class MyObserver2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if((Integer)arg == 0) {
            System.out.println("finished");
        }
    }
}
