package com.example.MyBankingProject.controller;


import com.example.MyBankingProject.entity.Loan;
import com.example.MyBankingProject.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin
public class LoanController {


    private final LoanService loanService;


    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @PostMapping("/apply")
    public Loan apply(@RequestBody Loan loan) {
        return loanService.applyLoan(loan);
    }


    @GetMapping
    public List<Loan> all() {
        return loanService.getAllLoans();
    }


    @PutMapping("/approve/{id}")
    public Loan approve(@PathVariable Long id) {
        return loanService.approveLoan(id);
    }


    @PutMapping("/reject/{id}")
    public Loan reject(@PathVariable Long id) {
        return loanService.rejectLoan(id);
    }
}
