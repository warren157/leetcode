package com.lintcode.dp.min_sub_arr;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 44.最小子数组
 * @date 2021/6/17 11:22
 */
public class MinSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-2,1};
        int i = minSubArray(nums);
        System.out.println(i);

    }

    public static int minSubArray(int[] nums) {
        int n= nums.length;
        if( n ==0 ){
            return 0;
        }
        int[] bp = new int[n];
        bp[0] = nums[0];
        for(int i=1;i<n;i++) {
            bp[i] = Math.min(nums[i],nums[i]+bp[i-1]);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            res = Math.min(bp[i],res);
        }
        return res;
    }
}
