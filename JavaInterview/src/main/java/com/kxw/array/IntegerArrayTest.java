package com.kxw.array;

import java.util.Arrays;

public class IntegerArrayTest {


    public static void main(String[] args) {
        test01(new Integer[]{0, 0, 3, 0, 0, 0, 8, 5, 7, 6});
    }

    private static void test01(Integer[] array) {
        int left = 0;
        int right = array.length - 1;
        int change = 0;
        while (left < right) {
            while (array[left] != 0) {
                left++;
            }
            while (array[right] == 0) {
                right--;
            }
            if (left < right) {
                Integer temp = array[left];
                array[left++] = array[right];
                array[right--] = temp;
                change++;
            }
        }
        System.out.println("共交换了" + change + "次");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
    }


}
