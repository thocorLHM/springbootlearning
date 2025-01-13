package de.muenchen.tc.group.controllers;


import de.muenchen.tc.group.servicelayer.SendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiGatewayController {

    @Autowired
    SendingService sendingService;

    @GetMapping(path="/cal")
    public String setNumber(@RequestParam(required = false) Integer number) {
        return sendingService.sendNumber(number);
    }
}
