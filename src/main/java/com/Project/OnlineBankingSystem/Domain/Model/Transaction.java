package com.Project.OnlineBankingSystem.Domain.Model;

import com.Project.OnlineBankingSystem.Common.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender_account", nullable = false, updatable = false)
    private String senderAccount;
    @Column(name = "receiver_account", nullable = false, updatable = false)
    private String receiverAccount;
    @Column(name = "amount", nullable = false, updatable = false)
    private double amount;
    @Column(name = "status", nullable = false)
    private TransactionStatus status;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction() {}
    public Transaction(
            Long id, final String senderAccount, final String receiverAccount, final double amount,
            final TransactionStatus status, final LocalDateTime createdAt, final LocalDateTime updatedAt,
            User user
    ) {
        this.id = id;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }
    public Long getId() {
        return id;
    }
    public String getSenderAccount() {
        return senderAccount;
    }
    public String getReceiverAccount() {
        return receiverAccount;
    }
    public double getAmount() {
        return amount;
    }
    public TransactionStatus getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
