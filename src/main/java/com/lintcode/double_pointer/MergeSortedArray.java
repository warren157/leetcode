package com.lintcode.double_pointer;

import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 88. 合并两个有序数组
 * nums1 = [1,2,3] m=3
 * nums2 = [2,5,6] n=3
 * nums1[nums1_pointer] <nums2[nums2_pointer]  sorted[0]= nums1[0] nums1_pointer++
 * nums1[nums1_pointer] <nums2[nums2_pointer] sorted[1]= nums1[1] nums1_pointer++
 * nums1[nums1_pointer] >nums2[nums2_pointer] sorted[2]= nums2[0] nums2_pointer++
 * nums1[nums1_pointer] <nums2[nums2_pointer] sorted[3] = nums1[2] nums1_pointer++ 越界
 * <p>
 * while(nums1_pointer<=m-1 && nums2_pointer<=n-1) {
 * if(nums1[nums1_pointer] <nums2[nums2_pointer]){
 * sorted[sortedIndex] =  nums1[nums1_pointer]
 * nums1_pointer++;
 * }else {
 * sorted[sortedIndex]= nums2[nums2_pointer]
 * nums2_pointer++
 * }
 * }
 * <p>
 * 分析：
 * 1.两个排好序的数组
 * 2.创建一个新数组 int sorted[] = new int[m+n]
 * 3.利用双指针移动确定最小值
 * 1.初始化 nums1_pointer = 0;
 * 2.初始化 nums2_pointer = 0;
 * 3.初始化 sortedIndex = 0;
 * 4.if(nums1[nums1_pointer]<nums2[nums2_pointer]){
 * sorted[sortedIndex] = nums1[nums1_pointer];
 * nums1_pointer++;
 * sortedIndex++;
 * }
 * @param:
 * @description:
 * @return:
 * @author: rui.wang
 * @date: 2021/6/21
 */

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3,0,0,};
        int[] nums2 = null;
        System.out.println(Arrays.toString(mergeSortedArray(nums1, 3, nums2, 3)));
    }

    public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int length = m + n;
        if(nums1 ==null || m <= 0){
            return nums2;
        }
        if (nums2 ==null ||n <= 0 ) {
            return nums1;
        }
        int[] sorted = new int[m + n];
        int nums1_pointer = 0;
        int nums2_pointer = 0;
        int sortedIndex = 0;
        while (nums1_pointer <= m - 1 && nums2_pointer <= n - 1) {
            if (nums1[nums1_pointer] <= nums2[nums2_pointer]) {
                sorted[sortedIndex] = nums1[nums1_pointer];
                nums1_pointer++;
                sortedIndex++;
            } else {
                sorted[sortedIndex] = nums2[nums2_pointer];
                nums2_pointer++;
                sortedIndex++;
            }
        }
        //判断nums1有没有数据
        if (nums1_pointer <= m - 1) {
            for (; nums1_pointer <= m - 1; nums1_pointer++) {
                sorted[sortedIndex] = nums1[nums1_pointer];
                sortedIndex++;
            }
        }
        //判断nums2有没有数据
        if (nums2_pointer <= n - 1) {
            for (; nums2_pointer <= n - 1; nums2_pointer++) {
                sorted[sortedIndex] = nums2[nums2_pointer];
                sortedIndex++;
            }
        }
        return sorted;
    }
}
