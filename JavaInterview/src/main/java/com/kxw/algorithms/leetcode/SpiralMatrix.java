package com.kxw.algorithms.leetcode;

/**
 * 打印螺旋数字
 *
 * Created by kangxiongwei on 2017/6/4.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] array = spiral(5);
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }


    private static int[][] spiral(int k) {
        int[][] array = new int[k][k];
        //奇数的最后一个数，肯定是k * k，并且独自占用一圈
        int center = k / 2;
        if (k % 2 == 1) array[center][center] = k * k;
        //计算总共需要多少圈
        int t = k / 2;
        //当前圈的坐标位置
        int left = 0;
        int right = k - 1;
        int top = 0;
        int bottom = k - 1;
        int init = 1; //第i圈的初始值
        //当前第i圈
        for (int i = 1; i <= t; i++) {
            //计算第i圈的初始值
            System.out.println("当前第" + i + "圈，初始值为" + init);
            //当前圈的每个元素赋值
            for (int n = left; n <= right; n++) {
                array[top][n] = init++;
            }
            top++;
            //
            for (int n = top; n <= bottom; n++) {
                array[n][right] = init++;
            }
            right--;
            //
            for (int n = right; n >= left; n--) {
                array[bottom][n] = init++;
            }
            bottom--;
            //
            for (int n = bottom; n >= top; n--) {
                array[n][left] = init++;
            }
            left++;
        }

        return array;
    }

}
