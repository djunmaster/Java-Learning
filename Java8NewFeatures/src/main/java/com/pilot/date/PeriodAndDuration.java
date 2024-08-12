package com.pilot.date;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodAndDuration {
    @Test
    public void calcPeriod() {
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(10).plusMonths(5).plusYears(1);

        int days = Period.between(d1, d2).getDays();
        int months = Period.between(d1, d2).getMonths();
        int years = Period.between(d1, d2).getYears();

        System.out.println("当前日期: " + d1 + " 最终日期 " + d2);
        System.out.println("相差天数: " + days);
        System.out.println("相差月份: " + months);
        System.out.println("相差年份 " + years);
    }

    @Test
    public void calcDuration() {
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = t1.plusHours(10).plusMinutes(5).plusSeconds(15);

        long secs = Duration.between(t2, t1).getSeconds();

        System.out.println("当前时间: " + t1 + " 最终时间 " + t2);
        System.out.println("相差秒数: " + secs);
    }
}
