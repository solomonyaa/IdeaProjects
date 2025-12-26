package dev.lpa;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        //Date
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate five5 = LocalDate.of(2022, 5, 5);
        System.out.println(five5);

        LocalDate may5th = LocalDate.of(2022, Month.MAY, 5);
        System.out.println(may5th);

        LocalDate day125 = LocalDate.ofYearDay(2022, 125);
        System.out.println(day125);

        LocalDate may5 = LocalDate.parse("2022-05-05");
        System.out.println(may5);

        System.out.println(may5.getEra());
        System.out.println(may5.getYear());
        System.out.println(may5.getMonth());
        System.out.println(may5.getMonthValue());

        System.out.println(may5.getDayOfMonth());
        System.out.println(may5.getDayOfWeek());
        System.out.println(may5.getDayOfYear());

        System.out.println("-".repeat(20));
        System.out.println(may5.get(ChronoField.YEAR));
        System.out.println(may5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(may5.get(ChronoField.DAY_OF_MONTH));
        System.out.println(may5.get(ChronoField.DAY_OF_YEAR));

        System.out.println(may5.withYear(2000));
        System.out.println(may5.withMonth(3));
        System.out.println(may5.withDayOfMonth(4));
        System.out.println(may5.withDayOfYear(126));
        System.out.println(may5);

        System.out.println("-".repeat(20));

        System.out.println(may5.plusYears(1));
        System.out.println(may5.plusMonths(12));
        System.out.println(may5.plusDays(365));
        System.out.println(may5.plusWeeks(52));

        System.out.println(may5.plus(365, ChronoUnit.DAYS));

        System.out.println("-".repeat(20));

        System.out.println("May 5 > today? " + may5.isAfter(today));
        System.out.println("today > May 5? " + may5.isBefore(today));

        System.out.println("May 5 > today? " + may5.compareTo(today));
        System.out.println("today > May 5? " + today.compareTo(may5));

        System.out.println("today = now ? " + today.compareTo(LocalDate.now()));
        System.out.println("today = now ? " + today.equals(LocalDate.now()));

        System.out.println(today.plusYears(3).isLeapYear());
        System.out.println(today.minusYears(1).isLeapYear());

        System.out.println("-".repeat(50));

        may5.datesUntil(may5.plusDays(7)) // Stream<LocalDate>
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        may5.datesUntil(may5.plusYears(1), Period.ofWeeks(1))
                .forEach(System.out::println);

        //Time
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println(sevenAM);

        LocalTime sevenThirtyPM = LocalTime.of(19, 30, 15);
        System.out.println(sevenThirtyPM);

        LocalTime eightPM = LocalTime.parse("20:00");
        LocalTime eightThirtyPM = LocalTime.parse("20:00:02.1002");

        // 0 --> AM, 1 --> PM
        System.out.println(eightPM + " (" + eightPM.get(ChronoField.AMPM_OF_DAY) + ")");
        System.out.println(eightThirtyPM);

        System.out.println(eightThirtyPM.getHour());
        System.out.println(eightThirtyPM.get(ChronoField.HOUR_OF_DAY));
        System.out.println(eightThirtyPM.plus(2, ChronoUnit.HOURS));

        System.out.println(eightPM.range(ChronoField.HOUR_OF_DAY)); // 0 - 23
        System.out.println(eightPM.range(ChronoField.MINUTE_OF_HOUR)); // 0 - 59
        System.out.println(eightPM.range(ChronoField.MINUTE_OF_DAY)); // 0 - 1439
        System.out.println(eightPM.range(ChronoField.SECOND_OF_MINUTE)); // 0 - 59
        System.out.println(eightPM.range(ChronoField.SECOND_OF_DAY)); // 0 - 86399

        //DateTime
        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(todayAndNow);

        LocalDateTime may5Noon = LocalDateTime.of(2022, 5, 5,
                12, 0);

        System.out.printf("%tD %tr %n", may5Noon, may5Noon);
        System.out.printf("%1$tF %1$tT %n", may5Noon);

        System.out.println(todayAndNow.format(DateTimeFormatter.ISO_WEEK_DATE));

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(may5Noon.format(dtf));

        System.out.println(may5Noon.format
                (DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        LocalDateTime may6Noon = may5Noon.plusHours(24);
        System.out.println(may6Noon.format(DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.MEDIUM)));


    }
}