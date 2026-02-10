package com.example.MyBankingProject.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loans")
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserOld customer;


    private Double loanAmount;
    private Double interestRate;
    private Integer durationMonths;
    private String status;
    private Date issuedDate;


}