package com.amrittiwari.banking.account.dao;

public class AccountClosedResponse {
    boolean isAccountClosed;

    public AccountClosedResponse() {
    }

    public AccountClosedResponse(boolean isAccountClosed) {
        this.isAccountClosed = isAccountClosed;
    }

    public boolean isAccountClosed() {
        return isAccountClosed;
    }

    public void setAccountClosed(boolean accountClosed) {
        isAccountClosed = accountClosed;
    }

    @Override
    public String toString() {
        return "AccountClosedResponse{" +
                "isAccountClosed=" + isAccountClosed +
                '}';
    }
}
