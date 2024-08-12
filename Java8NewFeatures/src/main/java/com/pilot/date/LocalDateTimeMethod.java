package com.pilot.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeMethod {

    @Test
    public void createLocalDateTime() {
        LocalDateTime currDateTime = LocalDateTime.now();
        LocalDateTime dt1 = LocalDateTime.of(2020, 8, 13, 5, 32);
        LocalDateTime dt2 = LocalDateTime.parse("2020-08-13T05:32");

        System.out.println(currDateTime);
        System.out.println(dt1);
        System.out.println(dt2);
    }


    @Test
    public void calcLocalDateTime() {
        LocalDateTime currDateTime = LocalDateTime.now();
        // 加十天
        LocalDateTime dt1 = currDateTime.plusDays(10);
        // 减十小时
        LocalDateTime dt2 = currDateTime.minusHours(5);

        System.out.println(currDateTime);
        System.out.println(dt1);
        System.out.println(dt2);
    }


    @Test
    public void getLocalDateTimeDimensions() {
        LocalDateTime currDateTime = LocalDateTime.now();
        int hour = currDateTime.getHour();
        int dayOfMonth = currDateTime.getDayOfMonth();
        Month month = currDateTime.getMonth();

        System.out.println(currDateTime);
        System.out.println("Hour: " + hour);
        System.out.println("Day of Month: " + dayOfMonth);
        System.out.println("Month: " + month);
    }

    @Test
    public void FormatDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        String formatDateTime = dateTime.format(DateTimeFormatter.ofPattern("(dd-MM-yyyy)"));
        System.out.println(formatDateTime);
    }
}
