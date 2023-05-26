package com.amrittiwari.banking.balance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "balance")
public class Balance {

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

    public Balance() {
    }

    public Balance(UUID accountNumber, long amountInRupees, long amountInPaisa) {
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
