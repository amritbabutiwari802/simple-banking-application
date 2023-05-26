package com.amrittiwari.banking.transaction.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "deposit_ledger")
public class DepositLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private UUID accountNumber;

    @Column(nullable = false)
    private long amountInRupees;

    @Column(nullable = false)
    private long amountInPaisa;

    @Column
    private UUID withdrawId;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

    @Column
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    public DepositLedger() {
    }

    public DepositLedger(UUID accountNumber, long amountInRupees, long amountInPaisa, UUID withdrawId, String remarks, TransactionType transactionType) {
        this.accountNumber = accountNumber;
        this.amountInRupees = amountInRupees;
        this.amountInPaisa = amountInPaisa;
        this.withdrawId = withdrawId;
        this.remarks = remarks;
        this.transactionType = transactionType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAmountInRupees() {
        return amountInRupees;
    }

    public void setAmountInRupees(long amountInRupees) {
        this.amountInRupees = amountInRupees;
    }

    public long getAmountInPaisa() {
        return amountInPaisa;
    }

    public void setAmountInPaisa(long amountInPaisa) {
        this.amountInPaisa = amountInPaisa;
    }

    public UUID getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(UUID withdrawId) {
        this.withdrawId = withdrawId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", amountInRupees=" + amountInRupees +
                ", amountInPaisa=" + amountInPaisa +
                ", withdrawId=" + withdrawId +
                ", remarks='" + remarks + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public enum TransactionType {
        DEPOSIT,
        TRANSFER
    }
}
