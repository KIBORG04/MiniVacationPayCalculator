package com.vacation_calculator.controllers;

import com.vacation_calculator.services.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationController {
    public VacationPayService vacationPayService;

    public VacationController( @Autowired VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    /**
     * @param salary Зарплата за год
     * @param vacationDays Количество отпускных дней
     */
    @GetMapping("/calculate")
    public ResponseEntity<String> CalculateVacation(
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "days", required = false) int vacationDays
    ) {
        return vacationPayService.getVacationPay(salary, vacationDays);
    }

    /**
     * @param salary Зарплата за год
     * @param vacationStart Дата начала отпуска
     * @param vacationEnd Дата окончания отпуска
     */
    @GetMapping("/calculate_by_date")
    public ResponseEntity<String> CalculateVacationByDates(
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "vacationStart") LocalDate vacationStart,
            @RequestParam(value = "vacationEnd") LocalDate vacationEnd
    ) {
        return vacationPayService.getVacationPay(salary, vacationStart, vacationEnd);
    }
}
