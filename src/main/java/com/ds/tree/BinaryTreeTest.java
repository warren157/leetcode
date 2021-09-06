package com.ds.tree;

import com.ds.list.HeroNode;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 15:02
 */
public class BinaryTreeTest {

    class HeroNode {
        int id;
        String name;
        HeroNode left;
        HeroNode right;

        public HeroNode(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }


    }
}
