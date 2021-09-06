package com.ds.array;

import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 26. 删除有序数组中的重复项
 * @date 2021/9/6 10:20
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int arr[] = {1,1,2};
        int slow = removeDuplicates(arr);
        System.out.println(slow);
        for (int i =0;i<slow;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int removeDuplicates(int[] arr) {

        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (arr[fast] != arr[fast - 1]) {
                arr[slow] = arr[fast];
                slow=slow+1;
            }
            fast=fast+1;
        }
        return slow;
    }
}
