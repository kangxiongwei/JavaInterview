package com.kxw.pattern.observer;

/**
 * Created by kangxiongwei on 2015/7/13.
 */
public class Watcher implements AbstractWatcher {

    @Override
    public void update() {
        System.out.println("watcher updated");
    }
}
