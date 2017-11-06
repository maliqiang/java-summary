/**
 * @file DateTest.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.learn;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

import static java.time.temporal.TemporalAdjusters.*;
import static org.junit.Assert.assertEquals;


/**
 * Java8日期操作
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-11-06
 */
public class DateTest {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test() {
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2017-11-06 13:55:00");
        //单位
        TemporalField hourOfDay = ChronoField.HOUR_OF_DAY;
        //获取12小时制的时间（小时数）
        TemporalField hourOfAmpm = ChronoField.HOUR_OF_AMPM;

        System.out.println(temporalAccessor.get(hourOfAmpm));
    }

    @Test
    public void testDemo1() {
        /**
         * The following contens was excerpted from
         * @see <a href="http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html">JDK Reference Document</a>
         */
        // The current date and time
        LocalDateTime timePoint = LocalDateTime.now();
        // get time from values(year,month,day)
        LocalDate ofValues = LocalDate.of(2012, Month.DECEMBER, 12);
        // middle of 1970
        LocalDate ofEpochDay = LocalDate.ofEpochDay(150);
        // The date of this year's a day
        LocalDate ofYearDay = LocalDate.ofYearDay(2017, 150);
        // get time from hour and minute
        LocalTime fromHours = LocalTime.of(17, 18);
        // From a String
        LocalTime parseTime = LocalTime.parse("10:15:30");

        //output result
        outputMSg("The current DateTime is", timePoint);
        outputMSg("Parse Time", parseTime);
        outputMSg("LocalDate's of", ofValues);
        outputMSg("LocalTime's of", fromHours);
        outputMSg("LocalDate's ofEpochDay", ofEpochDay);
        outputMSg("The day of this year is", ofYearDay);

    }

    @Test
    public void testDemo2() {
        LocalDateTime timePoint = LocalDateTime.now();
        LocalDate theDate = timePoint.toLocalDate();
        Month month = timePoint.getMonth();
        int day = timePoint.getDayOfMonth();
        int second = timePoint.getSecond();

        outputMSg("theDate", theDate);
        outputMSg("month", month);
        outputMSg("day", day);
        outputMSg("second", second);
    }

    @Test
    public void testDemo3() {
        LocalDateTime timePoint = LocalDateTime.now();
        // Set the value, returning a new object
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
        outputMSg("today is", timePoint);
        outputMSg("new DateTime", thePast);
        /**
         *  You can use direct manipulation methods or pass a value and field pair
         *
         */
        LocalDateTime plusWeeks = thePast.plusWeeks(3);
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
        outputMSg("plus 3 weeks", plusWeeks);
        outputMSg("plus 6 weeks", yetAnother);
    }

    @Test
    public void testSelfDefinedAjuster() {
        LocalDateTime timePoint = LocalDateTime.now();
        //当前时间的日期设置为本月最后一天
        LocalDateTime foo = timePoint.with(lastDayOfMonth());
        //当前时间的日期设置为这周前一周的周几
        LocalDateTime bar = timePoint.with(previousOrSame(DayOfWeek.WEDNESDAY));

        // Using value classes as adjusters
        LocalDateTime adjuster = timePoint.with(LocalTime.now());

        outputMSg("now", timePoint);
        outputMSg("foo", foo);
        outputMSg("bar", bar);
        outputMSg("adjuster", adjuster);
    }

    @Test
    public void testTruncate() {
        LocalTime time = LocalTime.now();
        LocalTime millisTime = time.truncatedTo(ChronoUnit.MILLIS);
        LocalTime truncatedTime = time.truncatedTo(ChronoUnit.SECONDS);


        outputMSg("millisTime", millisTime);
        outputMSg("truncatedTime", truncatedTime);
    }

    @Test
    public void testDemo4() {
        LocalDateTime dateTime = LocalDateTime.now();
        // You can specify the zone id when creating a zoned date time
        ZoneId id = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(dateTime, id);
        outputMSg("zoned", zoned);
        assertEquals(id, ZoneId.from(zoned));

        OffsetTime time = OffsetTime.now();

        ZoneOffset offset = ZoneOffset.UTC;
        // changes offset, while keeping the same point on the timeline
        OffsetTime sameTimeDifferentOffset = time.withOffsetSameInstant(
                offset);
        // changes the offset, and updates the point on the timeline
        OffsetTime changeTimeWithNewOffset = time.withOffsetSameLocal(
                offset);
        // Can also create new object with altered fields as before
        changeTimeWithNewOffset
                .withHour(3)
                .plusSeconds(2);
        outputMSg("changeTimeWithNewOffset",changeTimeWithNewOffset);
    }

    @Test
    public void testPeriod(){
        LocalDate oldDate = LocalDate.now();
        ZonedDateTime oldDateTime = ZonedDateTime.now();

        // 3 years, 2 months, 1 day
        Period period = Period.of(3, 2, 1);

        // You can modify the values of dates using periods
        LocalDate newDate = oldDate.plus(period);
        ZonedDateTime newDateTime = oldDateTime.minus(period);
        // Components of a Period are represented by ChronoUnit values
        outputMSg("newDate",newDate);
        outputMSg("newDateTime",newDateTime);
        outputMSg("day",period.get(ChronoUnit.DAYS));

    }

    @Test
    public void testDuration(){
        // A duration of 3 seconds and 5 nanoseconds
        Duration duration = Duration.ofSeconds(3, 5);
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime yesterday = LocalDateTime.parse("2017-11-03 14:29:30",dateTimeFormatter);
        Duration oneDay = Duration.between(today, yesterday);
        outputMSg("duration",duration);
        outputMSg("oneDay",oneDay);

        long days  = Math.abs(ChronoUnit.DAYS.between(today, yesterday));
        outputMSg("days",days);
    }




    public void outputMSg(String prefixMsg, Object dateInfo) {
        System.out.println(prefixMsg + ":\t" + dateInfo);
    }
}
