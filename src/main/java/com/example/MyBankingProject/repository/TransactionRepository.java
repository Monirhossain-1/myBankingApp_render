package com.example.MyBankingProject.repository;

import com.example.MyBankingProject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> { }

