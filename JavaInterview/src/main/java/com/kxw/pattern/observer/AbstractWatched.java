package com.kxw.pattern.observer;

/**
 * Created by kangxiongwei on 2015/7/13.
 * 抽象被观察者角色
 */
public interface AbstractWatched {

    void registerWatcher(AbstractWatcher watcher);

    void removeWatcher(AbstractWatcher watcher);

    void removeAllWatcher();

    void changeStatus();

}
