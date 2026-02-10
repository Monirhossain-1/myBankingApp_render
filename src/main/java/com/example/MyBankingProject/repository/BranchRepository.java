package com.example.MyBankingProject.repository;

import com.example.MyBankingProject.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
