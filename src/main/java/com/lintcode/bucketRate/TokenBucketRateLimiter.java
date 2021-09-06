package com.lintcode.bucketRate;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 令牌桶算法实现
 * 以固定速率增加令牌，如果桶满了则不添加
 * @date 2021/7/22 11:21
 */
public class TokenBucketRateLimiter {

    private int rate ;//每秒增加的令牌数量
    private long lastAddTokenTime;//上一次补充令牌的时间
    private long capacity ;// 令牌桶的容量
    private long currentTokenNums;//当前令牌桶的令牌数量

    public TokenBucketRateLimiter(long capacity ,int rate){
        this.capacity = capacity;
        this.currentTokenNums = capacity;
        this.rate = rate;
        this.lastAddTokenTime = System.currentTimeMillis();
    }

    //获取令牌
    public boolean acquire(){
        return acquire(1);
    }

    public boolean acquire(int permit){

        if(permit > currentTokenNums) { //表示当前令牌桶中没有足够令牌
            long currentTime = System.currentTimeMillis();
            long time = currentTime - lastAddTokenTime ;
            long tokenNums = (time/1000 * rate);//每秒新增的token数
            if (tokenNums >0){
                currentTokenNums = Math.min(tokenNums+currentTokenNums,capacity);
                this.lastAddTokenTime = currentTime;
            }
            if(permit>currentTokenNums) return false;
        }
        this.currentTokenNums -= permit;
        return true;
    }
}
