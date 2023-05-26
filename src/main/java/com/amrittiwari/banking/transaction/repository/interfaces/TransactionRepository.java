package com.amrittiwari.banking.transaction.repository.interfaces;

import com.amrittiwari.banking.common.entities.Money;
import com.amrittiwari.banking.common.exceptions.AccountBlockedException;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;

import java.util.UUID;

public interface TransactionRepository {
    public boolean writeDeposit(UUID accountNumber, Money money, String remarks) ;
    public boolean writeWithdraw(UUID accountNumber, Money money, String remarks);
    public boolean writeTransfer(UUID from, UUID to, Money money, String remarks);
}
