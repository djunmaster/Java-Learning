package com.pilot.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateMethod {

    @Test
    public void getLocalDate() {
        LocalDate date = LocalDate.of(2021, 8, 13);
        System.out.print("Date: " + date);
    }

    @Test
    public void parseLocalDate() {
        LocalDate date = LocalDate.parse("2021-08-13");
        System.out.print("Date: " + date);
    }

    @Test
    public void localDateCalc() {
        LocalDate currDate = LocalDate.now();
        LocalDate yesterday = currDate.minusDays(1);
        LocalDate tomorrow = currDate.plusDays(1);
        LocalDate lastMonth = currDate.minusMonths(1);
        LocalDate nextMonth = currDate.plusMonths(1);


        System.out.println("Current Date: " + currDate);
        System.out.println("tomorrow's Date: " + tomorrow);
        System.out.println("Yesterday's Date: " + yesterday);
        System.out.println("lastMonth's Date: " + lastMonth);
        System.out.println("nextMonth's Date: " + nextMonth);
    }

    @Test
    public void localDateCalc2() {
        LocalDate currDate = LocalDate.now();
        LocalDate date1 = currDate.plus(5, ChronoUnit.MONTHS);
        LocalDate date2 = currDate.minus(5, ChronoUnit.DAYS);

        System.out.println("当前日期: " + currDate);
        System.out.println("当前日期加五个月: " + date1);
        System.out.println("当前日期减五天: " + date2);
    }


    @Test
    public void getLocalDateWay() {
        LocalDate currDate = LocalDate.now();
        DayOfWeek dayOfWeek = currDate.getDayOfWeek();
        int dayOfMonth = currDate.getDayOfMonth();
        int dayOfYear = currDate.getDayOfYear();

        System.out.println("Date: " + currDate);
        System.out.println("Day of Week: " + dayOfWeek);
        System.out.println("Day of Month: " + dayOfMonth);
        System.out.println("Day of Year: " + dayOfYear);
    }


    @Test
    public void compareDate() {
        LocalDate currDate = LocalDate.now();
        LocalDate tomorrow = currDate.plusDays(1);
        LocalDate yesterday = currDate.minusDays(1);

        System.out.println("当前时间日期是否大于昨天: " + currDate.isAfter(yesterday));
        System.out.println("当前时间日期是否小于明天: " + currDate.isBefore(tomorrow));
    }

    @Test
    public void otherDateMethod() {
        System.out.println(LocalDate.now().isLeapYear());
    }
}
