package com.example.MyBankingProject.repository;

import com.example.MyBankingProject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> { }

