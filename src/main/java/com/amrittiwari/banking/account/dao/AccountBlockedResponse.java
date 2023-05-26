package com.amrittiwari.banking.account.dao;

public class AccountBlockedResponse {
    boolean accountBlocked;

    public AccountBlockedResponse() {
    }

    public AccountBlockedResponse(boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    public boolean isAccountBlocked() {
        return accountBlocked;
    }

    public void setAccountBlocked(boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    @Override
    public String toString() {
        return "AccountBlockedResponse{" +
                "accountBlocked=" + accountBlocked +
                '}';
    }
}
