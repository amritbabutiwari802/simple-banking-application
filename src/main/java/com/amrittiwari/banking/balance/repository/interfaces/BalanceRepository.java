package com.amrittiwari.banking.balance.repository.interfaces;

import com.amrittiwari.banking.balance.models.Balance;
import com.amrittiwari.banking.common.exceptions.AccountNotFreezedException;
import com.amrittiwari.banking.balance.utils.SubstractException;
import com.amrittiwari.banking.common.entities.Money;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;

import java.util.UUID;

public interface BalanceRepository {
    public Balance initialize(UUID accountNumber);
    public Balance deposit(UUID accountNumber, Money addend) ;
    public Balance withdraw(UUID accountNumber, Money substractend)throws SubstractException;
    public boolean freezeBalance(UUID accountNumber) ;
    public boolean unfreezeBalance(UUID accountNumber) ;

    public boolean close(UUID accountNumber);
}
