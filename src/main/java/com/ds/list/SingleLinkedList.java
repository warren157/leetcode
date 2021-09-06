package com.ds.list;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * 考虑这样一个场景：使用带 head 头的 单向链表 实现水浒英雄排行榜管理
 * 1.完成对英雄人物的 增删改查 操作
 * 2.第一种方法：在添加英雄时，直接添加到链表的尾部
 * @date 2021/9/3 13:32
 */
public class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 不考虑编号顺序
     *  1.找到当前链表的最后节点
     *  2.将最后整个节点的next指向新的节点
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if(temp.next ==null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean isExist = false;
        while(true) {
            if(temp ==null ) {
                break;
            }

            if(node.no < temp.no){
                break;
            }
            if(node.no == temp.no){
                isExist=true;
                break;
            }
            temp = temp.next;
        }
        if(isExist) {
            System.out.println("Node已经存在");
            return;
        }
        // 把节点插入到 temp 和 temp.next 之间
        // temp  ->  node  -> temp.next
        node.next = temp.next;
        temp.next = node;
    }
    /**
     * 打印链表中的数据
     */
    public void list(){
        if(head.next ==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }
}
