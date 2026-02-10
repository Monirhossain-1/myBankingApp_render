package com.example.MyBankingProject.service;


import com.example.MyBankingProject.entity.Notification;
import com.example.MyBankingProject.entity.UserOld;
import com.example.MyBankingProject.repository.NotificationRepository;
import com.example.MyBankingProject.repository.UserRepositoryOld;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notifyRepo;
    private final UserRepositoryOld userRepo;

    public NotificationService(NotificationRepository notifyRepo, UserRepositoryOld userRepo) {
        this.notifyRepo = notifyRepo;
        this.userRepo = userRepo;
    }

    public Notification send(Long userId, String message, String type) {
        UserOld user = userRepo.findById(userId).orElseThrow();

        Notification n = new Notification();
        n.setCustomer(user);
        n.setMessage(message);
        n.setType(type);
        n.setCreatedDate(new Date());
        n.setSeen(false);

        return notifyRepo.save(n);
    }

    public List<Notification> all() {
        return notifyRepo.findAll();
    }

    public Notification seen(Long notifyId) {
        Notification n = notifyRepo.findById(notifyId).orElseThrow();
        n.setSeen(true);
        return notifyRepo.save(n);
    }
}

