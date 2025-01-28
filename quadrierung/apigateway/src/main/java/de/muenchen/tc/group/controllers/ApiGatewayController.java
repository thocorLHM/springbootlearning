package de.muenchen.tc.group.controllers;


import de.muenchen.tc.group.servicelayer.DatabankSendingService;
import de.muenchen.tc.group.servicelayer.SendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiGatewayController {

    //Für die einfache Quadrierung
    @Autowired
    SendingService sendingService;

    //Für die Quadrierung und für das Schreiben des Ergebnisses in die Datenbank
    @Autowired
    DatabankSendingService databankSendingService;

    @GetMapping(path="/cal")
    public String setNumber(@RequestParam(required = false) Integer number) {
        return sendingService.sendNumbertoBackend(number);
    }

    @GetMapping(path = "/sending")
    public String setNumberforDatabank(@RequestParam(required = false) Integer number) {
        return databankSendingService.sendNumbertoDatabank(number);
    }
}
