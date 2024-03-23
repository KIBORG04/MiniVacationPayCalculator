package com.vacation_calculator.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

/**
 * Класс-хелпер для работы с праздниками
 */
public final class Holidays {
    /**
     * Список государственных праздников на основе ст. 112 ТКРФ
     */
    private static final Set<Holiday> ruHolidays = Set.of(
            new Holiday(Month.JANUARY, 1),
            new Holiday(Month.JANUARY, 2),
            new Holiday(Month.JANUARY, 3),
            new Holiday(Month.JANUARY, 4),
            new Holiday(Month.JANUARY, 5),
            new Holiday(Month.JANUARY, 6),
            new Holiday(Month.JANUARY, 7),
            new Holiday(Month.JANUARY, 8),
            new Holiday(Month.FEBRUARY, 23),
            new Holiday(Month.MARCH, 8),
            new Holiday(Month.MAY, 1),
            new Holiday(Month.MAY, 9),
            new Holiday(Month.JUNE, 12),
            new Holiday(Month.NOVEMBER, 4)
    );

    public static boolean isHoliday(LocalDate date) {
        for (Holiday holiday : ruHolidays) {
            if(holiday.day == date.getDayOfMonth() && holiday.month == date.getMonth())
                return true;
        }
        return false;
    }
}

