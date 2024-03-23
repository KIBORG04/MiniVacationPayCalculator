package com.vacation_calculator.inregration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class VacationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getCorrectVacationPayTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate").
                        param("salary", "900000").
                        param("days", "20"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("49315.0"));
    }

    @Test
    void getCorrectVacationPayByDatesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate_by_date").
                        param("salary", "900000").
                        param("vacationStart", "2024-10-01").
                        param("vacationEnd", "2024-10-10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("24658.0"));
    }

    @Test
    void getIncorrectVacationPayByDatesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate_by_date").
                        param("salary", "900000").
                        param("vacationStart", "2025-10-30").
                        param("vacationEnd", "2024-10-10"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
