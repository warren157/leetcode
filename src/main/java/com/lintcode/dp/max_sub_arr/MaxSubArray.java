package com.lintcode.dp.max_sub_arr;

import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 41 · 最大子数组
 * @date 2021/6/17 10:36
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
        int i = maxSubArray(nums);
        System.out.println(i);

    }

    public  static int maxSubArray(int[] nums){
        int n= nums.length;
        if( n==0 ) {
            return 0;
        }
        int[] dp = new int[n];
        //初始化
        dp[0] = nums[0];
        //状态转移
        for(int i=1;i<n;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        int res = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
