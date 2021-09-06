package com.ds.array;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 27. 移除元素
 * @date 2021/9/6 11:09
 */
public class RemoveElement {

    public static void main(String[] args) {
        int arr[] = {1,2,2,3};
        int slow = removeElement(arr,4);
        System.out.println(slow);
        for (int i=0;i<slow;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    public static int removeElement(int[] nums, int val) {

        if(nums == null || nums.length==0){
            return 0;
        }
        int length = nums.length;
        int slow = 0;
        int fast = 0;
        while(fast<length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow = slow+1;
                fast = fast+1;
            }else{
                fast = fast+1;
            }
        }
        return slow;
    }
}
