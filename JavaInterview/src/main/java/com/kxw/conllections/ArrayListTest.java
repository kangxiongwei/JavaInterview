package com.kxw.conllections;

import java.util.*;

/**
 * Created by kangxiongwei on 2015/7/3.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        test02();

    }

    private static void test02() {
        List<Integer> list = Arrays.asList(5, 7, 8, 6, 1, 2, 3, 4);

        /**
         * 会抛异常，因为会走迭代器，modCount和expectModCount不相等异常
         */
        /*for (Integer i: list) {
            System.out.println(i);
            list.remove(i);
        }*/

        /**
         * 不会抛异常，但是由于size在变化，i也在变化，导致取得结果不正确
         */
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(list.get(i));
        }*/

        /**
         * 正确姿势，因为iterator内部expectModCount会被修改为modCount，删除元素后游标会回退1格
         */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
            iterator.remove();
        }
    }

    private static void test01() {
        List<String> list = new ArrayList<String>();
        PriorityQueue<String> queue = new PriorityQueue<String>();
        Map<String, String> map2 = new HashMap<String, String>();
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("kang", "xiongwei");
        queue.add("kang");
        queue.add("xiong");
        queue.add("wei");
        System.out.println(queue.poll());
    }

}
