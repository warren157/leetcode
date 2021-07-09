package com.lintcode.dp;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额
 * 分析{3,2,3,0,3,0,1}
 * 定义一个一维数组 int[] dp = new int[nums.length]
 * 当nums=1时，dp[0] = nums[0]
 * 当nums=2时，
 *  dp[0]= nums[0]
 *  dp[1] = max(nums[1],dp[0])
 * 当nums=3时，
 *  dp[0]= nums[0]
 *  dp[1] = max(nums[1],dp[0])
 *  dp[2] = max(nums[1]+dp[0],dp[1])
 *  定义转移方程
 *  dp[n] = max(nums[n-1]+dp[n-2],dp[n-1])
 *  最后结果
 *  dp[n]
 * @date 2021/7/9 14:06
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {3,2,3,0,3,0,1};
        System.out.println(rob(nums));
    }
    public static Integer rob(int[] nums){
        if (nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],dp[0]);
        int i=2;
        for (;i<nums.length;i++) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[i-1];
    }
}
