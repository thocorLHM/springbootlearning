package de.muenchen.tc.group.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class SendingService {

    @Autowired
    HttpRequestService httpRequestService;

    private static final String SERVICE_URL = "http://localhost:4712/quad";

    public String sendNumbertoBackend(final int number) {
        return httpRequestService.sendPostRequest(SERVICE_URL, number);
    }
}
