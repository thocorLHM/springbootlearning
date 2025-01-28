package com.example.quad.repository;

import com.example.quad.entities.Calculation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public class CalculationRepository {
    private final JdbcTemplate jdbcTemplate;

    public CalculationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Calculation calculation) {
        String sql = "INSERT INTO calculations (input_number, squared_number, calculated_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                            calculation.getInputNumber(),
                            calculation.getSquaredNumber(),
                            calculation.getCalculatedAt() != null ? calculation.getCalculatedAt() : LocalDateTime.now());
    }
}