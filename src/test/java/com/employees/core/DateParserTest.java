package com.employees.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void parseDateParsesLongDateNumeric() {
        String date1 = "2023-05-20";
        String date2 = "2023.05.20";
        String date3 = "2023 05 20";
        String date4 = "2023/05/20";

        int yearExpected = 2023;
        int monthExpected = 5;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateParsesShortDateNumeric() {
        String date1 = "23-05-20";
        String date2 = "23.05.20";
        String date3 = "23 05 20";
        String date4 = "23/05/20";

        int yearExpected = 2023;
        int monthExpected = 5;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateParsesLongYearLongDateText() {
        String date1 = "2023-April-20";
        String date2 = "2023.April.20";
        String date3 = "2023 April 20";
        String date4 = "2023/April/20";

        int yearExpected = 2023;
        int monthExpected = 4;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateParsesShortYearLongDateText() {
        String date1 = "23-April-20";
        String date2 = "23.April.20";
        String date3 = "23 April 20";
        String date4 = "23/April/20";

        int yearExpected = 2023;
        int monthExpected = 4;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateParsesLongYearShortDateText() {
        String date1 = "2023-Apr-20";
        String date2 = "2023.Apr.20";
        String date3 = "2023 Apr 20";
        String date4 = "2023/Apr/20";

        int yearExpected = 2023;
        int monthExpected = 4;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateParsesShortYearShortDateText() {
        String date1 = "23-Apr-20";
        String date2 = "23.Apr.20";
        String date3 = "23 Apr 20";
        String date4 = "23/Apr/20";

        int yearExpected = 2023;
        int monthExpected = 4;
        int dateExpected = 20;

        LocalDate localDate1 = DateParser.parseDate(date1);
        assertEquals(yearExpected, localDate1.getYear());
        assertEquals(monthExpected, localDate1.getMonthValue());
        assertEquals(dateExpected, localDate1.getDayOfMonth());

        LocalDate localDate2 = DateParser.parseDate(date2);
        assertEquals(yearExpected, localDate2.getYear());
        assertEquals(monthExpected, localDate2.getMonthValue());
        assertEquals(dateExpected, localDate2.getDayOfMonth());

        LocalDate localDate3 = DateParser.parseDate(date3);
        assertEquals(yearExpected, localDate3.getYear());
        assertEquals(monthExpected, localDate3.getMonthValue());
        assertEquals(dateExpected, localDate3.getDayOfMonth());

        LocalDate localDate4 = DateParser.parseDate(date4);
        assertEquals(yearExpected, localDate4.getYear());
        assertEquals(monthExpected, localDate4.getMonthValue());
        assertEquals(dateExpected, localDate4.getDayOfMonth());
    }

    @Test
    void parseDateThrowsExceptionOnInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("-10-05-20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("5.05.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023.15.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023.A.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023.Април.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023.05.40"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023-05.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023 05.20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("2023+05+20"));
        assertThrows(IllegalArgumentException.class, () -> DateParser.parseDate("  2023.05.20"));
    }
}