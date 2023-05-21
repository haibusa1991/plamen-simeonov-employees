package com.employees.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DateParser {
    public static LocalDate parseDate(String date) {
        for (DateTimeFormatter formatter : dateFormats()) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (Exception ignored) {

            }
        }

        throw new IllegalArgumentException("Date format not recognized.");
    }

    private static List<DateTimeFormatter> dateFormats() {
        List<DateTimeFormatter> formatters = new ArrayList<>();

        formatters.add(DateTimeFormatter.ofPattern("yyyy-M-d"));
        formatters.add(DateTimeFormatter.ofPattern("yyyy.M.d"));
        formatters.add(DateTimeFormatter.ofPattern("yyyy M d"));
        formatters.add(DateTimeFormatter.ofPattern("yyyy/M/d"));

        formatters.add(DateTimeFormatter.ofPattern("yy-M-d"));
        formatters.add(DateTimeFormatter.ofPattern("yy.M.d"));
        formatters.add(DateTimeFormatter.ofPattern("yy M d"));
        formatters.add(DateTimeFormatter.ofPattern("yy/M/d"));

        formatters.add(getFullMonthFormatter("yyyy-MMMM-d"));
        formatters.add(getFullMonthFormatter("yyyy.MMMM.d"));
        formatters.add(getFullMonthFormatter("yyyy MMMM d"));
        formatters.add(getFullMonthFormatter("yyyy/MMMM/d"));

        formatters.add(getFullMonthFormatter("yy-MMMM-d"));
        formatters.add(getFullMonthFormatter("yy.MMMM.d"));
        formatters.add(getFullMonthFormatter("yy MMMM d"));
        formatters.add(getFullMonthFormatter("yy/MMMM/d"));

        formatters.add(getFullMonthFormatter("yyyy-MMM-d"));
        formatters.add(getFullMonthFormatter("yyyy.MMM.d"));
        formatters.add(getFullMonthFormatter("yyyy MMM d"));
        formatters.add(getFullMonthFormatter("yyyy/MMM/d"));

        formatters.add(getFullMonthFormatter("yy-MMM-d"));
        formatters.add(getFullMonthFormatter("yy.MMM.d"));
        formatters.add(getFullMonthFormatter("yy MMM d"));
        formatters.add(getFullMonthFormatter("yy/MMM/d"));

        return formatters;
    }

    private static DateTimeFormatter getFullMonthFormatter(String pattern) {
        return new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern(pattern)
                .toFormatter(Locale.US);
    }

    //returns -1 on no overlap or number of days overlapping.
    public static long getTimeOverlap(LocalDate firstPeriodStart, LocalDate firstPeriodEnd, LocalDate secondPeriodStart, LocalDate secondPeriodEnd) {
        if (firstPeriodStart.isAfter(secondPeriodStart)) {
            LocalDate tempStart = secondPeriodStart;
            secondPeriodStart = firstPeriodStart;
            firstPeriodStart = tempStart;

            LocalDate tempEnd = secondPeriodEnd;
            secondPeriodEnd = firstPeriodEnd;
            firstPeriodEnd = tempEnd;
        }

        if (firstPeriodEnd.isBefore(secondPeriodStart)) {
            return -1;
        }

        if (firstPeriodEnd.isBefore(secondPeriodEnd)) {
            return ChronoUnit.DAYS.between(secondPeriodStart, firstPeriodEnd.plusDays(1));
        }

        return ChronoUnit.DAYS.between(secondPeriodStart, secondPeriodEnd.plusDays(1));
    }
}
