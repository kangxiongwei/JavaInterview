package com.kxw.sort;

import java.util.Arrays;

/**
 * Created by kangxiongwei on 2015/7/3.
 * 堆排序
 * 1、基本思想：
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 堆的定义下：
 * 具有n个元素的序列（h1,h2,...,hn),
 * 当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。
 * 完全二叉树可以很直观地表示堆的结构。
 * 堆顶为根，其它为左子树、右子树。
 * 思想:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
 * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。
 * 依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
 * 所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 * 2、实例
 * 初始序列：46,79,56,38,40,84
 * 建堆：
 * 交换，从堆中踢出最大数
 * 依次类推：最后堆中剩余的最后两个结点交换，踢出一个，排序完成。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        int arrayLength=a.length;
        //循环建堆
        for(int i=arrayLength/2; i>0; i++){
            heapAdjust(a,arrayLength,i);
        }
    }

    /**
     * 调整堆
     * @param array
     * @param size
     * @param index 父节点的数组下标
     */
    private static void heapAdjust(int[] array,int size,int index){
        int left = index*2;
        int right = index*2+1;
        int temp = index;
        //左节点大于父节点
        if (left<size && array[left]> array[index]) {
            temp = left;
        }
        if (right<size && array[right] > array[temp]) {
            temp = right;
        }
        if (index != temp) {
            swap(array,index,temp);
            heapAdjust(array,size,index);
        }
    }

    //交换
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
