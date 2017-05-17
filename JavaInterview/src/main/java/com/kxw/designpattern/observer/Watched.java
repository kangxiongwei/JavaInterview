package com.kxw.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangxiongwei on 2015/7/13.
 */
public class Watched implements AbstractWatched {

    private List<AbstractWatcher> watcherList = new ArrayList<AbstractWatcher>();


    @Override
    public void registerWatcher(AbstractWatcher watcher) {
        this.watcherList.add(watcher);
    }

    @Override
    public void removeWatcher(AbstractWatcher watcher) {
        this.watcherList.remove(watcher);
    }

    @Override
    public void removeAllWatcher() {
        this.watcherList.clear();
    }

    @Override
    public void changeStatus() {
        System.out.println("watched change status");

        for(AbstractWatcher watcher: watcherList){
            watcher.update();
        }
    }
}
