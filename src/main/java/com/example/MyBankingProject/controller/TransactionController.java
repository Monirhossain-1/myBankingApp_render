package com.example.MyBankingProject.controller;


import com.example.MyBankingProject.entity.Account;
import com.example.MyBankingProject.entity.Transaction;
import com.example.MyBankingProject.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Transaction get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/deposit/{accountId}/{amount}")
    public Account deposit(@PathVariable Long accountId, @PathVariable Double amount) {
        return service.deposit(accountId, amount);
    }

    @PostMapping("/withdraw/{accountId}/{amount}")
    public Account withdraw(@PathVariable Long accountId, @PathVariable Double amount) {
        return service.withdraw(accountId, amount);
    }

    @PostMapping("/transfer/{fromId}/{toId}/{amount}")
    public String transfer(@PathVariable Long fromId, @PathVariable Long toId, @PathVariable Double amount) {
        return service.transfer(fromId, toId, amount);
    }
}