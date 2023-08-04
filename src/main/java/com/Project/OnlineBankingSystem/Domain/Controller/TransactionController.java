package com.Project.OnlineBankingSystem.Domain.Controller;

import com.Project.OnlineBankingSystem.Domain.Service.AccountService;
import com.Project.OnlineBankingSystem.Domain.Model.Transaction;
import com.Project.OnlineBankingSystem.Domain.Service.TransactionService;
import com.Project.OnlineBankingSystem.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final UserService userService;
    @Autowired
    public TransactionController(TransactionService transactionService, AccountService accountService,
                                 UserService userService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<Transaction>> getAllTransaction(Pageable pagination) {
        Page<Transaction> transactions = transactionService.getAllTransaction(pagination);
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransaction(id).orElse(null);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaction);
    }
    /*PostMapping
    public Transaction makeTransaction(@RequestBody Transaction transaction) {
        User user = ;
    }*/
}
