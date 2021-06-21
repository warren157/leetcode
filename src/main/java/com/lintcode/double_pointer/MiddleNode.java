package com.lintcode.double_pointer;

import java.util.LinkedList;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 9:11
 */
public class MiddleNode {

    public static void main(String[] args) {
        LinkedList<Integer> nodes = new LinkedList<>();
        nodes.add(1);nodes.add(2);
        nodes.add(3);nodes.add(4);
        System.out.println(middleNode(nodes));
    }

    public static Integer middleNode(LinkedList<Integer> nodes){
        Integer fast =0; Integer low = 0;
        int length = nodes.size();
        int res = 0;
        while( low<=length && fast+2<=length ) {
                fast = fast + 2;
                low = low + 1 ;
                res = nodes.get(low);
        }
        return res;
    }
}
