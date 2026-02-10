package com.example.MyBankingProject.service;


import com.example.MyBankingProject.entity.Account;
import com.example.MyBankingProject.entity.UserOld;
import com.example.MyBankingProject.repository.AccountRepository;
import com.example.MyBankingProject.repository.UserRepositoryOld;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepo;
    private final UserRepositoryOld userRepo;

    public AccountService(AccountRepository accountRepo, UserRepositoryOld userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    // Create account for a user
    public Account createAccount(Long userId, Account account) {
        UserOld user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        account.setCustomer(user);
        account.setCreatedDate(new Date());
        account.setStatus("ACTIVE");
        return accountRepo.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    // Get account by ID
    public Account getAccountById(Long accountId) {
        return accountRepo.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // Update account info
    public Account updateAccount(Long accountId, Account accountDetails) {
        Account account = accountRepo.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountType(accountDetails.getAccountType());
        account.setStatus(accountDetails.getStatus());
        return accountRepo.save(account);
    }

    // Delete account
    public void deleteAccount(Long accountId) {
        accountRepo.deleteById(accountId);
    }

    // Deposit money
    public Account deposit(Long accountId, Double amount) {
        Account account = getAccountById(accountId);
        account.setBalance(account.getBalance() + amount);
        return accountRepo.save(account);
    }

    // Withdraw money
    public Account withdraw(Long accountId, Double amount) {
        Account account = getAccountById(accountId);
        if(account.getBalance() < amount) throw new RuntimeException("Insufficient balance");
        account.setBalance(account.getBalance() - amount);
        return accountRepo.save(account);
    }

    // Transfer money
    public void transfer(Long fromAccountId, Long toAccountId, Double amount) {
        Account from = getAccountById(fromAccountId);
        Account to = getAccountById(toAccountId);

        if(from.getBalance() < amount) throw new RuntimeException("Insufficient balance");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountRepo.save(from);
        accountRepo.save(to);
    }
}