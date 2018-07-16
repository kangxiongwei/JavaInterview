package com.kxw.pattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kangxiongwei3 on 2017/5/26 17:36.
 */
public class ConcreteAggregate implements Aggregate {

    private List list;

    public ConcreteAggregate(List list) {
        this.list = list;
    }

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(list);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public int getSize() {
        return list.size();
    }


    private static class ArrayIterator implements Iterator {

        private List list;
        private Integer index = 0;

        ArrayIterator(List list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.size() > index;
        }

        @Override
        public Object next() {
            return hasNext() ? list.get(index++) : null;
        }
    }

}
