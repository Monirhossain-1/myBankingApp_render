package com.example.MyBankingProject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String transactionType;
    private Double amount;
    private Date date;
    private String description;
    private String status;


    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;


    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
}