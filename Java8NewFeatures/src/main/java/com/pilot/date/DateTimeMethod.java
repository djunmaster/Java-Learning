package com.pilot.date;

import org.junit.Test;

import java.time.*;

public class DateTimeMethod {

    @Test
    public void getCurrentDateAndTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(currentDate);
        System.out.println(currentTime);
        System.out.println(currentDateTime);
        System.out.println(zonedDateTime);
    }

    @Test
    public void getZonedDateTime() {
        // 获取当前时区时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // 获取纽约当前时区时间
        ZonedDateTime newYorkZoneDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newYorkZoneDateTime);

    }


    
}
