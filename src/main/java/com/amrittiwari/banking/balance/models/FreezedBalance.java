package com.amrittiwari.banking.balance.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "freezedBalance")
public class FreezedBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID accountNumber;

    @Column(nullable = false)
    private long amountInRupees;

    @Column(nullable = false)
    private long amountInPaisa;

    public FreezedBalance() {
    }

    public FreezedBalance(UUID accountNumber, long amountInRupees, long amountInPaisa) {
        this.accountNumber = accountNumber;
        this.amountInRupees = amountInRupees;
        this.amountInPaisa = amountInPaisa;
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

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", amountInRupees=" + amountInRupees +
                ", amountInPaisa=" + amountInPaisa +
                '}';
    }
}
