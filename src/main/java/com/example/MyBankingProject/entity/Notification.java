package com.example.MyBankingProject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String message;
    private String type;
    private Date createdDate;
    private boolean seen;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserOld customer;
}