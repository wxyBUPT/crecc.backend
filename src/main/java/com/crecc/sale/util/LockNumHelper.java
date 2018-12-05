package com.crecc.sale.util;

/**
 * Created by xiyuanbupt on 2018/11/29.
 */
public class LockNumHelper {
    public static boolean isLockNumLegal(Integer num){
        /**
         * 判断八位数的锁是否合法
         */
        return 20170000 <= num && num <= 30170000;
    }
}
