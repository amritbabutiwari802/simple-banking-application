package com.amrittiwari.banking.transaction.dto;

import com.amrittiwari.banking.common.entities.Money;

import java.util.UUID;

public class TransferRequest {
    UUID to;
    UUID from ;

    Money money;
    String remarks;

    public TransferRequest() {
    }

    public TransferRequest(UUID to, UUID from, Money money, String remarks) {
        this.to = to;
        this.from = from;
        this.money = money;
        this.remarks = remarks;
    }

    public UUID getTo() {
        return to;
    }

    public void setTo(UUID to) {
        this.to = to;
    }

    public UUID getFrom() {
        return from;
    }

    public void setFrom(UUID from) {
        this.from = from;
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
        return "TransferRequest{" +
                "to=" + to +
                ", from=" + from +
                ", money=" + money +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
