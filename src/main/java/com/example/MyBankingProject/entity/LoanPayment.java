package com.example.MyBankingProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan_payments")
public class LoanPayment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amountPaid;

    private String paidDate;

    private Double remainingAmount;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
