package com.Project.OnlineBankingSystem.Domain.Controller;

import com.Project.OnlineBankingSystem.Domain.Service.AccountService;
import com.Project.OnlineBankingSystem.Domain.Model.Account;
import com.Project.OnlineBankingSystem.Domain.Model.User;
import com.Project.OnlineBankingSystem.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;
    @Autowired
    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<Account>> allAccounts(Pageable pagination) {
        Page<Account> accounts = accountService.getAllAccounts(pagination);
        return ResponseEntity.ok(accounts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return accountService.getAccount(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{account_number}")
    public ResponseEntity<Account> getByAccountNumber(@PathVariable String accountNumber) {
        Account account = accountService.getByAccountNumber(accountNumber);
        if (account == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    // PATCH IS NECESSARY OK

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        Account account = accountService.getAccount(id).orElse(null);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteAccount(id);
        return ResponseEntity.ok().body("Account deleted");
    }

    // ACCOUNT WITH USER
    @PostMapping("/{id}")
    public ResponseEntity<Account> saveAccountByUser(@PathVariable Long id, @RequestBody Account account) {
        User user = userService.getUser(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        Random random = new Random();
        long accountNumber = (long) (random.nextDouble() * 9_000_000_000L) + 1_000_000_000L;
        String transformed = String.valueOf(accountNumber);

        account.setAccountNumber(transformed);
        account.setUser(user);
        Account account_created = accountService.saveAccount(account);
        return ResponseEntity.ok(account_created);
    }
}
