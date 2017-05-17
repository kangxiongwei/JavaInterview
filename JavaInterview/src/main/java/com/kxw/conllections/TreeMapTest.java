package com.kxw.conllections;

import com.kxw.string.StringInterview;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by kangxiongwei on 2015/7/7.
 */
public class TreeMapTest {

    public static void main(String[] args){

        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(7,"meimei");
        map.put(5,"xiongwei");
        map.put(10,"xiongfei");
        map.put(3,"jianwei");
        map.put(6,"longfei");
        map.put(1,"xiwei");
        map.put(2,"dawei");
        map.put(8,"yongfei");
        map.put(12,"panfei");
        map.put(9,"rongrong");
        map.put(11,"leilei");
        map.put(13,"yanyan");
        map.put(14,"xiaxia");

        Set<Integer> set = map.keySet();
        for(Integer s: set) {
            System.out.println(s + "-->" + map.get(s));
        }

        map.remove(10);

    }

}
