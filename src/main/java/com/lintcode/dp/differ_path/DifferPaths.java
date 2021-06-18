package com.lintcode.dp.differ_path;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 114 · 不同的路径
 * 1.确定状态：到f(m,n)的路径和
 * 2.定义int[][] f = new int[m][n]
 * 3.初始化 ：f[0][n]=1
 *          f[n][0]=1
 * 4.状态转移方程：f(m,n)=f(m-1,n)+f(m,n-1)
 * @date 2021/6/17 14:32
 */
public class DifferPaths {

    public static void main(String[] args) {
        int res = differPaths(1,3);
        System.out.println(res);
    }

    public static int differPaths(int m,int n){

        if(m==0 && n==0) return 0;
        if(m==0) return 1;
        if(n==0) return 1;
        int[][] f = new int[m][n];
        //行初始化
        for(int i=0;i<m;i++){
            f[i][0] = 1;
        }
        //初始化列
        for(int i=0;i<n;i++){
            f[0][i] = 1;
        }
        //状态转移方程
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                f[i][j] = f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

}
