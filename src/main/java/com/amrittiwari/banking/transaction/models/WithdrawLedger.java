package com.amrittiwari.banking.transaction.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "withdraw_ledger")
public class WithdrawLedger {

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
    private UUID depositId;

    @Column
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    public WithdrawLedger() {
    }

    public WithdrawLedger(UUID accountNumber, long amountInRupees, long amountInPaisa, UUID depositId, String remarks, TransactionType transactionType) {
        this.accountNumber = accountNumber;
        this.amountInRupees = amountInRupees;
        this.amountInPaisa = amountInPaisa;
        this.depositId = depositId;
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

    public UUID getDepositId() {
        return depositId;
    }

    public void setDepositId(UUID depositId) {
        this.depositId = depositId;
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
        return "Withdraw{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", amountInRupees=" + amountInRupees +
                ", amountInPaisa=" + amountInPaisa +
                ", depositId=" + depositId +
                ", remarks='" + remarks + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }

    public enum TransactionType {
        WITHDRAW,
        TRANSFER
    }
}
