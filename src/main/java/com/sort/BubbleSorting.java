package com.sort;

import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 15:28
 */
public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {
        int temp = 0; // 临时变量，交换的时候使用
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

        }
        return arr;
    }
}
