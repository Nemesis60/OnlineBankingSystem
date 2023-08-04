package com.Project.OnlineBankingSystem.Domain.Service;

import com.Project.OnlineBankingSystem.Domain.Model.Account;
import com.Project.OnlineBankingSystem.Domain.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
    public Page<Account> getAllAccounts(Pageable pagination) {
        return accountRepository.findAll(pagination);
    }
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
