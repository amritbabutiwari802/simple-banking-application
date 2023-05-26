package com.amrittiwari.banking.common.exceptions;

public class AccountNotFoundException extends Exception {
    private String message;

    public AccountNotFoundException(String message) {
        this.message = message;
    }

    public AccountNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
