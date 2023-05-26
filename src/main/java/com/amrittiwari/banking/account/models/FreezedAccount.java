package com.amrittiwari.banking.account.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "freezed_accounts")
public class FreezedAccount {
    @Id
    @Column( nullable = false, unique = true)
    private UUID accountNumber;


    @Column(name = "reference_no", nullable = false)
    private String referenceNo;

    public FreezedAccount() {
    }

    public FreezedAccount(UUID accountNumber, String referenceNo) {
        this.accountNumber = accountNumber;
        this.referenceNo = referenceNo;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Override
    public String toString() {
        return "BlockedAccount{" +
                "accountNumber=" + accountNumber +
                ", referenceNo='" + referenceNo + '\'' +
                '}';
    }
}
