package com.example.MyBankingProject.repository;

import com.example.MyBankingProject.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<Loan, Long> { }

