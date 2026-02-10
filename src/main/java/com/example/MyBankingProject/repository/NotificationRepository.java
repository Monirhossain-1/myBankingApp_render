package com.example.MyBankingProject.repository;

import com.example.MyBankingProject.entity.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> { }

