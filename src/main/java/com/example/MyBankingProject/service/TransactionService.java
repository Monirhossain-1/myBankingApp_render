package com.example.MyBankingProject.service;


import com.example.MyBankingProject.entity.Account;
import com.example.MyBankingProject.entity.Transaction;
import com.example.MyBankingProject.repository.AccountRepository;
import com.example.MyBankingProject.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepo;
    private final AccountRepository accountRepo;

    public TransactionService(TransactionRepository transactionRepo, AccountRepository accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    public Transaction getById(Long id) {
        return transactionRepo.findById(id).orElseThrow();
    }

    // Save transaction record
    private void saveTransaction(String type, Double amount, Account from, Account to, String desc) {
        Transaction tr = new Transaction();
        tr.setTransactionType(type);
        tr.setAmount(amount);
        tr.setDate(new Date());
        tr.setFromAccount(from);
        tr.setToAccount(to);
        tr.setStatus("SUCCESS");
        tr.setDescription(desc);

        transactionRepo.save(tr);
    }

    // Deposit
    public Account deposit(Long accountId, Double amount) {
        Account acc = accountRepo.findById(accountId).orElseThrow();
        acc.setBalance(acc.getBalance() + amount);
        accountRepo.save(acc);

        saveTransaction("DEPOSIT", amount, null, acc, "Amount Deposited");
        return acc;
    }

    // Withdraw
    public Account withdraw(Long accountId, Double amount) {
        Account acc = accountRepo.findById(accountId).orElseThrow();
        if (acc.getBalance() < amount) throw new RuntimeException("Insufficient Balance");

        acc.setBalance(acc.getBalance() - amount);
        accountRepo.save(acc);

        saveTransaction("WITHDRAW", amount, acc, null, "Amount Withdrawn");
        return acc;
    }

    // Transfer
    public String transfer(Long fromId, Long toId, Double amount) {
        Account from = accountRepo.findById(fromId).orElseThrow();
        Account to = accountRepo.findById(toId).orElseThrow();

        if (from.getBalance() < amount) throw new RuntimeException("Insufficient Balance");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepo.save(from);
        accountRepo.save(to);

        saveTransaction("TRANSFER", amount, from, to, "Money Transferred");
        return "Transfer Completed";
    }
}