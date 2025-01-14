package com.example.quad.services;

import org.springframework.stereotype.Service;

@Service
public class QuadService {

    public int quadNumber(int number){
        return number*number;
    }
}
