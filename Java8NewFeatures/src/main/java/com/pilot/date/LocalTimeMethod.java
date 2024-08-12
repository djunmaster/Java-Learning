package com.pilot.date;

import org.junit.Test;

import java.time.LocalTime;

public class LocalTimeMethod {

    @Test
    public void getLocalTime() {
        LocalTime currTime = LocalTime.now();
        LocalTime localTime = LocalTime.of(5, 32, 44);
        LocalTime localTime2 = LocalTime.parse("05:32:44");

        System.out.println(currTime);
        System.out.println(localTime);
        System.out.println(localTime2);
    }

    @Test
    public void calcLocalTime() {
        // 获取指定时间
        LocalTime t1 = LocalTime.of(5, 32, 44);
        // 指定时间加两小时
        LocalTime t2 = t1.plusHours(2);
        // 指定时间减十分钟
        LocalTime t3 = t1.minusMinutes(10);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

    @Test
    public void getLocalTimeDimensions() {
        LocalTime t = LocalTime.of(5, 32, 44);
        int hours = t.getHour();
        int minutes = t.getMinute();
        int seconds = t.getSecond();

        System.out.println("指定时间: " + t);
        System.out.println("指定时间的小时数: " + hours);
        System.out.println("指定时间的分钟数: " + minutes);
        System.out.println("指定时间的秒数: " + seconds);
    }

    @Test
    public void compareLocalTime() {
        LocalTime t1 = LocalTime.of(5, 32, 44);
        // t1时间基础上添加一小时
        LocalTime t2 = t1.plusHours(1);

        // t1时间会比t2时间打嘛？
        boolean b = t1.isAfter(t2); //False
    }
}
