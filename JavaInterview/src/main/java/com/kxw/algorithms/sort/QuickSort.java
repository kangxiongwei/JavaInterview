package com.kxw.algorithms.sort;

/**
 * 快速排序
 * Created by kangxiongwei3 on 2017/5/18 15:28.
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] elements = {5, 3, 1, 2, 7, 8, 6};
        sort.quickSort(elements, 0, elements.length - 1);
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    void quickSort(int[] elements, int left, int right) {
        if (left < right) {
            //递归调用
            int index = partition(elements, left, right);
            partition(elements, 0, index - 1);
            partition(elements, index + 1, right);
        }
    }

    int partition(int[] elements, int left, int right) {
        int e = elements[left];
        while (left < right) {
            while (elements[right] > e && left < right) {
                right--;
            }
            if (left < right)
                elements[left++] = elements[right];
            while (elements[left] < e && left < right) {
                left++;
            }
            if (left < right)
                elements[right--] = elements[left];
        }
        elements[left] = e;
        return left;
    }


}
