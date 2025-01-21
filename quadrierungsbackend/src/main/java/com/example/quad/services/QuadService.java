package com.example.quad.services;

import com.example.quad.entities.Calculation;
import com.example.quad.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuadService {

    @Autowired
    private CalculationRepository calculationRepository;

    public int quadNumber(int inputNumber) {

        return inputNumber*inputNumber;
    }

    public Calculation quadNumberandSave(Integer inputNumber){

        Calculation calculation = new Calculation();
        calculation.setInputNumber(inputNumber);
        calculation.setSquaredNumber(inputNumber*inputNumber);
        calculation.setCalculatedAt(LocalDateTime.now());
        calculationRepository.save(calculation);
        return calculation;
    }
}
