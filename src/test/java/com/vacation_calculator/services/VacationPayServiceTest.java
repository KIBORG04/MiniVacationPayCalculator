package com.vacation_calculator.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VacationPayServiceTest {
    @Autowired
    VacationPayService vacationPayService;

    @Test
    void getVacationPay() {
        float result = vacationPayService.calculatePay(900000, 20);
        assertEquals(49315, result);
    }

    @Test
    void getVacationDaysByDatesWithoutHolidays() {
        int result = vacationPayService.getVacationDaysByDates(
                LocalDate.parse("2024-10-01"),
                LocalDate.parse("2024-10-10")
        );
        assertEquals(10, result);
    }

    @Test
    void getVacationDaysByDatesWithHolidays() {
        int result = vacationPayService.getVacationDaysByDates(
                LocalDate.parse("2024-02-20"),
                LocalDate.parse("2024-03-10")
        );
        assertEquals(18, result);
    }
}