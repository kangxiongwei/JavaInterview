package com.kxw.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kangxiongwei3 on 2017/5/26 17:40.
 */
public class IteratorClient {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Aggregate aggregate = new ConcreteAggregate(list);
        Iterator it = aggregate.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
