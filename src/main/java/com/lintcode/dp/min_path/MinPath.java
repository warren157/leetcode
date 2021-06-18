package com.lintcode.dp.min_path;

import com.sun.org.glassfish.gmbal.AMXMBeanInterface;

import javax.xml.crypto.dsig.spec.XPathType;
import java.util.Arrays;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 110 · 最小路径和
 * @date 2021/6/17 9:46
 */
public class MinPath {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(grid);

    }

    public static void  minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];

        paths[0][0] = grid[0][0];
        //初始化行
        for(int i=1;i< m ;i++){
            paths[i][0] = paths[i-1][0]+grid[i][0];
        }
        //初始化列
        for(int j=1;j<n ;j++){
            paths[0][j] = paths[0][j-1]+grid[0][j];
        }

        for (int i=0;i<m;i++){
            System.out.println(Arrays.toString(paths[i]));
        }

        //方程转移
        for(int i = 1;i<m;i++) {
            for (int j=1;j<n;j++) {
                paths[i][j] = Math.min(paths[i][j-1],paths[i-1][j])+grid[i][j];
            }
        }
        System.out.println(paths[m-1][m-1]);
    }
}
