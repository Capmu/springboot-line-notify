package com.capmu.linenotify.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class LineNotifyService {

    private static final String LINE_NOTIFY_API_URL = "https://notify-api.line.me/api/notify";

    public void sendNotification(String message, String token) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + token);

        String encodedMessage = new String(message.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        HttpEntity<String> request = new HttpEntity<>("message=" + encodedMessage, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(LINE_NOTIFY_API_URL, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Notification sent successfully!");
        } else {
            System.out.println("Failed to send notification!");
        }
    }
}
