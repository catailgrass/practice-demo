package com.flycat.other_class_group.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * joda time 类库相关方法
 * @author flying cat
 * @date 2021/12/27 14:33
 */
public class JodaTime {

    public static void main(String[] args) {
        long date = 1644302000000L;
        DateTime dateTime = new DateTime(date);

        System.out.println(dateTime);
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss.SSS"));

        System.out.println("toLocalDateTime " + dateTime.toLocalDateTime());
        DateTime plusDays = dateTime.plusDays(5);
        System.out.println(dateTime.toLocalDate());
        System.out.println(plusDays.toLocalDate());
        plusDays = plusDays.plusHours(5);
        plusDays = plusDays.plusMinutes(20);
        System.out.println(dateTime.toLocalTime());
        System.out.println(plusDays.toLocalTime());
        System.out.println(DateTime.parse("2021-12-27T16:00:00"));
        System.out.println(DateTime.parse("2021-12-27 16:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
