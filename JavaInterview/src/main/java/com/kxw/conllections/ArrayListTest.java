package com.kxw.conllections;

import java.util.*;

/**
 * Created by kangxiongwei on 2015/7/3.
 */
public class ArrayListTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        PriorityQueue<String> queue = new PriorityQueue<String>();
        Map<String,String> map2 = new HashMap<String, String>();
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        map.put("kang","xiongwei");
        queue.add("kang");
        queue.add("xiong");
        queue.add("wei");
        System.out.println(queue.poll());
    }

}
