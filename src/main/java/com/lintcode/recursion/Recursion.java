package com.lintcode.recursion;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/6 8:14
 */
public class Recursion {
    public static void main(String[] args) {
        test(4);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }
}
