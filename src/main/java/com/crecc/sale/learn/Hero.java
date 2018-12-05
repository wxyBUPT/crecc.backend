package com.crecc.sale.learn;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/11/16.
 */
public class Hero {

    @Deprecated
    public void say() {
        System.out.println("Noting has to say!");
    }

    public void speak() {
        System.out.println("I have a dream!");
    }

    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new java.sql.Date(System.currentTimeMillis()));
    }

    public static String getTimeZone() {
        Calendar cal = Calendar.getInstance();
        int offset = cal.get(Calendar.ZONE_OFFSET);
        cal.add(Calendar.MILLISECOND, -offset);
        Long timeStampUTC = cal.getTimeInMillis();
        Long timeStamp = System.currentTimeMillis();
        Long timeZone = (timeStamp - timeStampUTC) / (1000 * 3600);
        System.out.println(timeZone.intValue());
        return String.valueOf(timeZone);
    }
}
