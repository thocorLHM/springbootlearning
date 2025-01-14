package com.example.quad.controller;

import com.example.quad.services.QuadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2QuadController {

    @Autowired
    private QuadService quadService;

    @PostMapping("/quad")
    public int quad(@RequestBody int a) {

        int result = quadService.quadNumber(a);
        return result;
    }
}
