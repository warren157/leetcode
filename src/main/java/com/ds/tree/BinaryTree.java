package com.ds.tree;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/26 17:30
 */
public class BinaryTree<Key extends Comparable<Key>,Value>{
    //记录父节点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node {
        //存储键
        private Key key;
        //存储值
        private Value value;
        //左节点
        public Node left;
        //右节点
        private Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public Integer size(){
        return N;
    }

    //增加元素
    public  void  put(Key key,Value value){
       root =  put(root,key,value);
    }

    //向指定的树x中添加key-value并返回添加元素后新的树
    public  Node  put(Node x,Key key,Value value){
        //如果x树为空
        if(x==null) {
            N++;
            return new Node(key,value,null,null);
        }
        //如果x树不为空
        //比较x节点的键和key的大小
        //如果key小于x节点的键：则继续找x节点的左节点，否则就找右节点
        if( key.compareTo(x.key)>0){ //
            x.right = put(x.right,key,value);
        }else if(key.compareTo(x.key)<0){
            x.left =put(x.left,key,value);
        }else{
            x.value = value;
        }
        return x;
    }

    //根据key查询value
    public Value get(Key key) {

        return get(root,key);
    }

    //从指定的树x中查询key的值
    public Value get(Node x,Key key) {
        //x树为null
        if (x ==null) {
            return null;
        }
        //x树不为null
        //比较x节点的键和key的大小
        if( key.compareTo(x.key)>0){
            return  get(x.right,key);
        }else if(key.compareTo(x.key)<0){
            return  get(x.left,key);
        }else{
            //等于就是找到了key的节点，直接返回x节点的值
            return x.value;
        }
    }

    //根据key删除元素
    public void delete(Key key) {

    }

    //从指定的树x中删除key对应的value，并返回删除后的新树
    public Node delete(Node x,Key key) {
        //x树为null
        if(x ==null ){
            return null;
        }
        //x树不为null
        if( key.compareTo(x.key)>0){
            x.right =delete(x.right,key);
        }else if(key.compareTo(x.key)<0){
            x.left = delete(x.left,key);
        }else{
            //等于就是找到了key的节点，完成真正的删除动作，要删除的节点就是x
            //要找到右子树中最小的节点
            if(x.right==null){
                return x.left;
            }
            if(x.left==null) {
                return x.right;
            }

            Node minNode = x.right;
            while(minNode.left!=null) {
                minNode = minNode.left;
            }
            //删除右子树中的最小的节点
            Node n = x.right;
            while(n.left!=null) {
                if(n.left.left==null) {
                    n.left=null;
                }else{
                    n = n.left;
                }
            }
            //让x节点的左子树称为minNode左子树
            minNode.left=x.left;
            //让x节点的右子树称为minNode右子树
            minNode.right = x.right;
            //让x节点的父节点指向minNode
            x = minNode;
            N--;
        }
        return x;
    }

}
