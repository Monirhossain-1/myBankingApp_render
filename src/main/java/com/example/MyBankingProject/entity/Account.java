package com.example.MyBankingProject.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String accountNumber;
    private String accountType;
    private Double balance;
    private Date createdDate;
    private String status;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("accounts")
    private UserOld customer;


}