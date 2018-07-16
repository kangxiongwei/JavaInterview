package com.kxw.conllections;

public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + " ==> " + tableSizeFor(i));
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
