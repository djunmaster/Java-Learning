package com.pilot.hutool;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilMethod {
    @Test
    public void getNowDateMethod() {
        //当前时间
        Date date = DateUtil.date();
        System.out.println(date);
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println(date2);
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date3);
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);
    }


    @Test
    public void DateParseMethod() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        String dateStr2 = "2017-03-01  18:25:00";
        // parse 是字符串转Date日期
        Date date2 = DateUtil.parse(dateStr2, "yyyy-MM-dd");
        System.out.println(date2);
    }

    @Test
    public void DateFormatMethod() {
        System.out.println("====================================");
        String dateStr = "2017-03-01";
        // // parse 是字符串解析为日期
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
        // format 是Date日期转字符串
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println(format);
        System.out.println("====================================");
        //结果：2017-03-01：将Date转换为只保留日期的字符串
        String formatDate = DateUtil.formatDate(date);
        System.out.println(formatDate);
        //结果：2017-03-01 00:00:00：将Date转换为日期+时间的字符串
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println(formatDateTime);
        //结果：00:00:00：将Date转换为时间的字符串
        String formatTime = DateUtil.formatTime(date);
        System.out.println(formatTime);
        System.out.println("====================================");
        // 分别获取日期的年月日
        int year = DateUtil.year(date);
        System.out.println(year);
        int month = DateUtil.month(date);
        // 细节点：从0开始计数
        System.out.println(month + 1);
        int day = DateUtil.dayOfMonth(date);
        System.out.println(day);
        System.out.println("====================================");
    }

    @Test
    public void DateOffsetAndBetweenMethod() {
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        // 日期时间偏移
        //日期加2天：结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println(newDate);
        //日期减1天：结果：2017-02-28 22:33:23
        DateTime newDate2 = DateUtil.offset(date, DateField.DAY_OF_MONTH, -1);
        System.out.println(newDate2);
        // 日期加2小时：结果：2017-03-02 00:33:23
        DateTime newDate3 = DateUtil.offset(date, DateField.HOUR, 2);
        System.out.println(newDate3);
        //日期加三天：结果：2017-03-04 22:33:23
        DateTime newDate4 = DateUtil.offsetDay(date, 3);
        System.out.println(newDate4);
        //日期减三小时，结果：2017-03-01 19:33:23
        DateTime newDate5 = DateUtil.offsetHour(date, -3);
        System.out.println(newDate5);

        // 日期时间差
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        // 日期时间差
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println("相差日期：" + betweenDay);
        // 格式化时间差
        String formatHour = DateUtil.formatBetween(date1, date2, BetweenFormatter.Level.MINUTE);
        System.out.println("相差日期：" + formatHour);
    }
}
