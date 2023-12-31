package com.Project.OnlineBankingSystem.Domain.Repository;

import com.Project.OnlineBankingSystem.Domain.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Account findByAccountNumber(@Param("accountNumber") String accountNumber);
}
