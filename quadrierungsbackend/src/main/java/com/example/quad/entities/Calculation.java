package com.example.quad.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("CALCULATIONS")
public class Calculation {

    @Id
    private Integer id;

    private Integer inputNumber;
    private Integer squaredNumber;
    private LocalDateTime calculatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

    public Integer getSquaredNumber() {
        return squaredNumber;
    }

    public void setSquaredNumber(Integer squaredNumber) {
        this.squaredNumber = squaredNumber;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
