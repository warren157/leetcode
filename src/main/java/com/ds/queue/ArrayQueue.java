package com.ds.queue;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/27 16:12
 */
public class ArrayQueue {

    public static void main(String[] args) {
        int i=0;
        System.out.println(++i);
    }

    public class Queue{
        private int maxSize;
        private int head;
        private int tail;
        private int arr[];
        public Queue(int maxSize) {
            this.maxSize=maxSize;
            this.arr = new int[maxSize];
            this.head=-1;
            this.tail=-1;

        }

        public int get()  {
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            return arr[++head];
        }
        //添加数据
        public void add(int n){
            if (isFull()) {
                System.out.println("队列已满");
                return;
            }
            arr[++tail] = n;
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列为空");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d \n", i, arr[i]);
            }
        }

        public int head(){
            if (isEmpty()) {
                throw new RuntimeException("队列空");
            }
            return arr[head+1];
        }

        public int tail() {
            if (isEmpty()) {
                throw new RuntimeException("队列空");
            }
            return arr[tail];
        }


        //判断队列是否为空
        public boolean isEmpty(){
            return head == tail;
        }

        public boolean isFull(){
            return head == maxSize -1 ;
        }


    }
}
