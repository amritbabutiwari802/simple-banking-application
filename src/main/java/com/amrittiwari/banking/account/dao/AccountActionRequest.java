package com.amrittiwari.banking.account.dao;

import java.util.UUID;

public class AccountActionRequest {

    private UUID accountNumber;
    private String referenceNo;

    public AccountActionRequest() {
    }

    public AccountActionRequest(UUID accountNumber, String referenceNo) {
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
        return "AccountActionRequest{" +
                "accountNumber=" + accountNumber +
                ", referenceNo='" + referenceNo + '\'' +
                '}';
    }
}
