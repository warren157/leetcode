package com.lintcode.greedy;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/12 10:10
 */
public class IsMatch {
    public static void main(String[] args) {

    }

    public static boolean isMatch(String s,String p){

        int i = p.lastIndexOf("*");
        if(i>=0){ //表示字符串中有*
            //获取*前面的字符串
            p.substring(0, i);
        }

        if(p.contains("?")) {
            int index = p.indexOf("?");
            char c = s.charAt(index);
            String str =p.substring(0, index)+c+p.substring(index+1);
            if(s.equals(str)){
                return true;
            }else{
                return false;
            }

        }


        return false;
    }
}
