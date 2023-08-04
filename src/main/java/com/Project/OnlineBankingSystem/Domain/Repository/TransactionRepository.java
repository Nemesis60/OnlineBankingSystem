package com.Project.OnlineBankingSystem.Domain.Repository;

import com.Project.OnlineBankingSystem.Domain.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
