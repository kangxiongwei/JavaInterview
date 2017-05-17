package com.kxw.designpattern.observer;

import javax.crypto.interfaces.PBEKey;

/**
 * Created by kangxiongwei on 2015/7/13.
 * 抽象被观察者角色
 */
public interface AbstractWatched {

    public void registerWatcher(AbstractWatcher watcher);

    public void removeWatcher(AbstractWatcher watcher);

    public void removeAllWatcher();

    public void changeStatus();

}
