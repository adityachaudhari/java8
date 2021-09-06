package com.java8.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeAPIJava8 {
    public static void main(String[] args) {

        // get local date and time
        LocalDate localDate = LocalDate.now();
        System.out.println("Pringint LocalDate.now(): " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Pringint LocalDateTIme.now() : " + localDateTime);

        // read LocalDate values using TemporalFields
        System.out.println("Year of month : " + localDate.get(ChronoField.YEAR));
        System.out.println("month of year : " + localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("day of month : " + localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("week of year : " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));

        // get machine readable tme
        System.out.println("machine time : " + Instant.now());

        //Get duriation of a Period
        // below throw exception Unsupported unit: Seconds because the Duration class is
        //used to represent an amount of time measured in seconds and eventually nanoseconds, you
        //can’t pass a LocalDate to the between method.
        System.out.println("Duriation : " + Duration.between(LocalDate.now(), LocalDate.now().plusDays(5)));

        System.out.println("Period : " + Period.between(LocalDate.now(), LocalDate.now().plusDays(5)));

        // create Duration and Period
        //   Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        // parsing dates
        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        // creating date time from pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date11 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        LocalDate date22 = LocalDate.parse(formattedDate, formatter);


        // working with different time zone and calender.
        LocalDate date = LocalDate.of(2021, Month.SEPTEMBER, 05);
        Instant now = Instant.now();

        ZoneId zoneId = ZoneId.of( "America/Los_Angeles" );
        ZonedDateTime zdt = now.atZone( zoneId );

        // applying timezone to a point in time
        ZonedDateTime zdt1 = date.atStartOfDay(zoneId);

    }
}
