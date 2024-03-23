package com.vacation_calculator.services;

import com.vacation_calculator.utils.Holidays;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacationPayService {
    /**
     * Расчет отпускных по годовой зарлпате и количеству дней отпуска
     */
    public ResponseEntity<String> getVacationPay(int salary, int vacationDays) {
        float pay = calculatePay(salary, vacationDays);
        return ResponseEntity.ok(String.valueOf(pay));
    }

    /**
     * Расчет отпускных по годовой зарлпате и по датам начала и окончания отпуска
     */
    public ResponseEntity<String> getVacationPay(int salary, LocalDate vacationStart, LocalDate vacationEnd) {
        int vacationDays = getVacationDaysByDates(vacationStart, vacationEnd);
        float pay = calculatePay(salary, vacationDays);
        return ResponseEntity.ok(String.valueOf(pay));
    }

    /**
     * Подсчёт оплачиваемых дней отпуска
     * <br>Если <b>праздничный день</b>, то он не оплачивается как день отпуска
     * <br><small>Как я понял</small>
     */
    public int getVacationDaysByDates(LocalDate vacationStart, LocalDate vacationEnd) {
        int vacationDays = 0;

        LocalDate currentDay = vacationStart;
        vacationEnd = vacationEnd.plusDays(1);
        while(!currentDay.equals(vacationEnd)){
            if(!Holidays.isHoliday(currentDay))
                vacationDays++;

            currentDay = currentDay.plusDays(1);
        }

        return vacationDays;
    }

    /**
     * Расчёт отпускных по формуле: среднедневной заработок * количество дней отпуска
     */
    public float calculatePay(int salary, int vacationDays) {
        float vacationPay = ((float) salary / 365) * vacationDays;
        return Math.round(vacationPay);
    }
}
