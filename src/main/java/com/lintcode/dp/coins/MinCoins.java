package com.lintcode.dp.coins;

import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 9:04
 */
public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {1,3,5};
        int amount = 11;
        System.out.println(minCoins(coins, amount));
    }
    public static  int minCoins(int[] coins,int amount) {
        if (coins ==null || coins.length==0 || amount<=0) return -1;
        int max = amount + 1;
        int[] dp = new int[amount + 1];
         Arrays.fill(dp, max);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++) {
                if( i>=coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
