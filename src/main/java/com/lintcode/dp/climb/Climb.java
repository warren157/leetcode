package com.lintcode.dp.climb;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 111 · 爬楼梯
 * 分析：每次只能跨一个或者两个台阶，到终点的方式有多少种
 * | 0  | 1  | 2  |
 *  1.确定状态：最后一步 或者最后两步 f(i),到i台阶的方式数
 *  2.初始化：f(0)=1 f(1) =1
 *      分析：f(2) = f(1)+f(0) = 2
 *           f(3)=f(2)+f(1) = 2+1 = 3
 *  3.状态转移方程：f(i) = f(i-1)+f(i-2)
 *  4.返回f(i)
 * @date 2021/6/17 13:26
 */
public class Climb {
    public static void main(String[] args) {
        int climb = climb(4);
        System.out.println(climb);
    }

    public  static int climb(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
