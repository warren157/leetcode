package com.lintcode.greedy;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 122. 买卖股票的最佳时机 II
 * 运用贪心算法，判断后的价格是不是比前一个的大
 * @date 2021/7/12 9:59
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int max = 0;
        for (int i=0;i<prices.length-1;i++) {
            if(prices[i] <prices[i+1]) {
                max = max+(prices[i+1]-prices[i] );
            }
        }
        return max;
    }
}
