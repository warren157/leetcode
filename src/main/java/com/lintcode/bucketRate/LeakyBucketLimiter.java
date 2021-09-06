package com.lintcode.bucketRate;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/22 15:21
 */
public class LeakyBucketLimiter {

    private int capacity;
    private int urlCount = 0;
    private int rate;//每秒消费请求数
    private long lastAddUrlTime;
    public LeakyBucketLimiter(int capacity ,int rate) {
        this.capacity = capacity;
        this.rate = rate;
        lastAddUrlTime = System.currentTimeMillis();

    }

    public boolean acquire(){
        long currentTime = System.currentTimeMillis();
        urlCount = Math.max(0,(urlCount-((int)(currentTime-lastAddUrlTime)/1000 * rate )));
        lastAddUrlTime = currentTime;
        if(capacity - urlCount >=1) {
            urlCount+=1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeakyBucketLimiter leakyBucketLimiter = new LeakyBucketLimiter(10, 1);
        for (int i=0;i<=20;i++) {
            new Thread(() ->{
                System.out.println(leakyBucketLimiter.acquire());
            } ).start();
        }

    }
}
