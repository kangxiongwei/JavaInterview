package com.kxw.algorithms.sort;

import java.util.Arrays;

/**
 * 堆排序
 * Created by kangxiongwei3 on 2017/5/18 15:28.
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] elements = {3, 5, 6, 2, 1, 7, 8, 9};
        hs.heapSort(elements);
        System.out.println("最终结果为");
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 构建从根节点开始的大根堆
     *
     * @param elements 数组
     * @param root     根节点数组下标
     * @param length   数组长度
     */
    void maxHeap(int[] elements, int root, int length) {
        int largest, left = 2 * root + 1, right = 2 * root + 2;
        largest = left <= length && elements[left] > elements[root] ? left : root;
        largest = right <= length && elements[right] > elements[largest] ? right : largest;
        //System.out.println("当前根节点索引为" + root + ", 左孩子索引为" + left + ", 右孩子索引为" + right + ", 最大的索引为" + largest);
        if (largest != root) {
            int e = elements[root];
            elements[root] = elements[largest];
            elements[largest] = e;
            maxHeap(elements, largest, length);
        }
    }

    /**
     * 建堆
     *
     * @param elements
     * @param length
     */
    void buildHeap(int[] elements, int length) {
        for (int i = length / 2; i >= 0; i--) {
            maxHeap(elements, i, length);
        }
    }

    void heapSort(int[] elements) {
        buildHeap(elements, elements.length - 1);
        System.out.println("建堆完成，结果为：");
        System.out.println(Arrays.toString(elements));
        int length = elements.length - 1;
        //挑出一个最大的元素放在最后，再从剩余的元素中继续调
        for (int i = length; i >= 0; i--) {
            int e = elements[0];
            elements[0] = elements[i];
            elements[i] = e;
            maxHeap(elements, 0, --length);
        }
    }
}
