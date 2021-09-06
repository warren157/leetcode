package com.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 6 .Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 输入：PAYPALISHIRING
 *
 * 输出：P   A   H   N
 *      A P L S I I G
 *      Y   I   R
 *
 * rows=3
 * 第0行：0  4   8   12
 * 返回值：PAHNAPLSIIGYIR
 * @date 2021/7/16 17:10
 */
public class Convert {

    public  static String covert(String s, int numRows) {
        if(s==null || s.length()<=numRows) return s;
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
