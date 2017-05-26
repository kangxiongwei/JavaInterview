package com.kxw.pattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 * Created by kangxiongwei3 on 2017/5/26 17:27.
 */
public class ArrayIterator implements Iterator {

    private List list = null;
    private int index = 0;

    public ArrayIterator(List list) {
        super();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        return hasNext() ? list.get(index++) : null;
    }

}
