package com.vacation_calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VacationIncorrectException extends RuntimeException {
    public VacationIncorrectException(String message) {
        super(message);
    }
}
