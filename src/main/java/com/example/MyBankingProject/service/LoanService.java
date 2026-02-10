package com.example.MyBankingProject.service;


import com.example.MyBankingProject.entity.Loan;
import com.example.MyBankingProject.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {


    private final LoanRepository loanRepo;


    public LoanService(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }


    public Loan applyLoan(Loan loan) {
        loan.setStatus("PENDING");
        return loanRepo.save(loan);
    }


    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }


    public Loan approveLoan(Long id) {
        Loan loan = loanRepo.findById(id).orElseThrow();
        loan.setStatus("APPROVED");
        return loanRepo.save(loan);
    }


    public Loan rejectLoan(Long id) {
        Loan loan = loanRepo.findById(id).orElseThrow();
        loan.setStatus("REJECTED");
        return loanRepo.save(loan);
    }
}
