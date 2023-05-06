package com.capmu.linenotify.controller;

import com.capmu.linenotify.service.LineNotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LineNotifyController {

    private final LineNotifyService lineNotifyService;

    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(
            @RequestParam String message,
            @RequestParam String token) {

        lineNotifyService.sendNotification(message, token);
        return ResponseEntity.ok("Notification sent successfully!");
    }
}
