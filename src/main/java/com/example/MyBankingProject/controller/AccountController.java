package com.example.MyBankingProject.controller;

import com.example.MyBankingProject.entity.Account;
import com.example.MyBankingProject.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:4200") // Angular dev server
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create account for user
    @PostMapping("/create/{userId}")
    public ResponseEntity<Account> createAccount(@PathVariable Long userId, @RequestBody Account account) {
        Account created = accountService.createAccount(userId, account);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> allAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    // Update account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.updateAccount(id, account));
    }

    // Delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    // Deposit money
    @PostMapping("/deposit/{id}/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable Long id, @PathVariable Double amount) {
        return ResponseEntity.ok(accountService.deposit(id, amount));
    }

    // Withdraw money
    @PostMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<Account> withdraw(@PathVariable Long id, @PathVariable Double amount) {
        return ResponseEntity.ok(accountService.withdraw(id, amount));
    }

    // Transfer money
    @PostMapping("/transfer/{fromId}/{toId}/{amount}")
    public ResponseEntity<String> transfer(@PathVariable Long fromId, @PathVariable Long toId, @PathVariable Double amount) {
        accountService.transfer(fromId, toId, amount);
        return ResponseEntity.ok("Transfer Successful");
    }
}
