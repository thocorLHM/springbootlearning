package de.muenchen.tc.group.servicelayer;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class SendingService {

    private static final String SERVICE_URL = "http://localhost:4712/quad";

    public String sendNumber(final int number) {
        try {
            // JSON-String mit der Nummer erstellen
            String jsonBody = String.valueOf(number);

            // HttpClient erstellen
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest konfigurieren
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SERVICE_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // Anfrage senden und Antwort verarbeiten
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Antwort zurückgeben
            return "Antwort von Service: " + response.body();
        } catch (Exception e) {
            return "Fehler beim Senden der Nummer: " + e.getMessage();
        }
    }
}
