package com.amrittiwari.banking.transaction.dto;

import com.amrittiwari.banking.common.entities.Money;

import java.util.UUID;

public class DepositRequest {

    private UUID accountNumber;
    private Money money;
    private String remarks;

    public DepositRequest() {
    }

    public DepositRequest(UUID accountNumber, Money money, String remarks) {
        this.accountNumber = accountNumber;
        this.money = money;
        this.remarks = remarks;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "DepositRequest{" +
                "accountNumber=" + accountNumber +
                ", money=" + money +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
