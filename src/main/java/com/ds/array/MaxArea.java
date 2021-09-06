package com.ds.array;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 11. 盛最多水的容器
 * 解法，运用双指针，移动小的指针
 * @date 2021/9/6 9:22
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(arr);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] arr){
        if(arr ==null || arr.length==0){
            return 0;
        }
        int left = 0;
        int right=arr.length-1;
        int maxArea = 0;
        while(left<right) {
            //容量的大小取决于最小的数字，所以我们要取两个数字中最小的数字，Math.min(arr[left],arr[right])
            //然后再与maxArea比较取最大值
            //如果arr[left] 比arr[right]小，我们就移动做指针，否则就移动右指针
            maxArea = Math.max(Math.min(arr[left],arr[right])*(right-left),maxArea);
            if(arr[left]<arr[right]){
                left ++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
