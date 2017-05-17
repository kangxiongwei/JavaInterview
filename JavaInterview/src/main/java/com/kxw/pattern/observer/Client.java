package com.kxw.pattern.observer;

/**
 * Created by kangxiongwei on 2015/7/13.
 */
public class Client {

    public static void main(String[] args) {

        AbstractWatched watched = new Watched();

        AbstractWatcher watcher1 = new Watcher();
        AbstractWatcher watcher2 = new Watcher();
        AbstractWatcher watcher3 = new Watcher();

        watched.registerWatcher(watcher1);
        watched.registerWatcher(watcher2);
        watched.registerWatcher(watcher3);

        watched.changeStatus();

    }


}
