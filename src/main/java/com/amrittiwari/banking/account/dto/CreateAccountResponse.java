package com.amrittiwari.banking.account.dto;

import java.util.UUID;

public class CreateAccountResponse {
    private UUID accountNumber;

    public CreateAccountResponse() {
    }

    public CreateAccountResponse(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "CreateAccountResponse{" +
                "accountNumber=" + accountNumber +
                '}';
    }
}
