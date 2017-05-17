package com.kxw.conllections;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by kangxiongwei on 2015/7/3.
 */
public class PriorityQueueTest {

    public static void main(String[] args){
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<String>();
        queue.add("kang");
        queue.add("xiong");
        queue.add("wei");
    }

}
