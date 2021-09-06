package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 94. 二叉树的中序遍历
 * 前序：根左右 -> 右左根
 * 中序：左根右 -> 右根左
 * 后序：左右根 -> 根右左
 * @date 2021/7/20 9:59
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> sk = new Stack<>();
        while(root!=null || !sk.isEmpty()) {
            while(root !=null) {
                sk.push(root);
                root = root.left;
            }
            root = sk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
   public  static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

