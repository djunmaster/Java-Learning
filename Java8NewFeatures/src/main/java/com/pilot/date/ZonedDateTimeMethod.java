package com.pilot.date;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeMethod {

    @Test
    public void getZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        ZonedDateTime now1 = ZonedDateTime.now(zoneId);
        System.out.println(now1);
    }

    @Test
    public void getAllZoneIds() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void parseZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2021-08-13T17:35:08.044680100+09:00[Asia/Tokyo]");
        System.out.print(zonedDateTime);
    }
}
