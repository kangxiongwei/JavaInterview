package com.kxw.pattern.iterator;

import java.util.Iterator;

/**
 * Created by kangxiongwei3 on 2017/5/26 17:35.
 */
public interface Aggregate {

    void add(Object obj);

    Object get(int index);

    Iterator iterator();

    int getSize();

}
