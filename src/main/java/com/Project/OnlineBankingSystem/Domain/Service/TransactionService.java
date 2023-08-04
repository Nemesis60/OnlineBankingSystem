package com.Project.OnlineBankingSystem.Domain.Service;

import com.Project.OnlineBankingSystem.Domain.Model.Transaction;
import com.Project.OnlineBankingSystem.Domain.Repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> getAllTransaction(Pageable pagination) {
        return transactionRepository.findAll(pagination);
    }
    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
