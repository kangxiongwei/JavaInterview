package com.kxw.java8.stream;

import java.util.*;

/**
 * Create by kangxiongwei on 2018/6/21 12:09.
 */
public class MapStream {


    public static void main(String[] args) {
        List<String> a = Arrays.asList("zhangsan", "lisi", "wangwu");
        List<String> b = Arrays.asList("zhaoyu", "zhuda", "shaoqiang");
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);

        //流扁平化
        List<List<String>> ab = Arrays.asList(a, b);
        ab.stream().flatMap(Collection::stream).forEach(System.out::println);

        //将map中所有value的值拼接成字符串
        Optional<String> result = map.entrySet().stream().flatMap(entry -> entry.getValue().stream()).reduce((key, value) -> key + "," + value);
        System.out.println("map1: " + result.orElse(""));
        Optional<String> result2 = map.values().stream().flatMap(Collection::stream).reduce((key, value) -> key + "," + value);
        System.out.println("map2: " + result2.orElse(""));
        //将map中key，value拼接成一个字符串
        Optional<String> result3 = map.entrySet().stream().map(entry -> entry.getKey() + "->" + entry.getValue()).reduce(String::concat);
        System.out.println("map3: " + result3.orElse(""));

    }


}
