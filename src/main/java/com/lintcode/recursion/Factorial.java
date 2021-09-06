package com.lintcode.recursion;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 阶乘
 * @date 2021/9/6 8:44
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int n){
        if(n<=0){
            return 1;
        }
        int f = factorial(n - 1);
        System.out.printf("%d * %d = %d \n", f, n, f * n);
        return f*n;
    }
}
