package com.vacation_calculator.utils;

import java.time.Month;

/**
 * Простой класс, содержащий базовую инорфмацию по празднику
 */
public final class Holiday {
    Month month;
    int day;

    public Holiday(Month month, int day) {
        this.month = month;
        this.day = day;
    }
}
