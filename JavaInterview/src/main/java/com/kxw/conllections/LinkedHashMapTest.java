package com.kxw.conllections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 利用LinkedHashMap，可以实现LRU算法，accessOrder表示是否按照访问顺序排序，如果为true，则会根据访问顺序排序，否则按照插入顺序排序
 * Create by kangxiongwei on 2018/1/24 14:59.
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("xiong", "kangwei");
        map.put("wei", "kangxiong");
        map.put("kang", "xiongwei");

        map.get("kang");
        map.get("xiong");
        map.get("wei");
        map.get("xiong");

        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }


}
