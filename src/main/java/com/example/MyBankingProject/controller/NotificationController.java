package com.example.MyBankingProject.controller;


import com.example.MyBankingProject.entity.Notification;
import com.example.MyBankingProject.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/send/{userId}")
    public Notification send(@PathVariable Long userId, @RequestParam String message, @RequestParam String type) {
        return service.send(userId, message, type);
    }

    @GetMapping
    public List<Notification> all() {
        return service.all();
    }

    @PutMapping("/seen/{id}")
    public Notification seen(@PathVariable Long id) {
        return service.seen(id);
    }
}
