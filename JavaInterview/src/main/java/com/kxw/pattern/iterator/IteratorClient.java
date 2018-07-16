package com.kxw.pattern.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kangxiongwei3 on 2017/5/26 17:40.
 */
public class IteratorClient {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Aggregate aggregate = new ConcreteAggregate(list);
        Iterator it = aggregate.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
