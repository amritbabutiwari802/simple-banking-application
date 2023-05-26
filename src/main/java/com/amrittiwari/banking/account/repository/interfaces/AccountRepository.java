package com.amrittiwari.banking.account.repository.interfaces;

import com.amrittiwari.banking.account.models.Account;
import com.amrittiwari.banking.account.models.Address;
import com.amrittiwari.banking.common.exceptions.AccountAlreadyFreezedException;
import com.amrittiwari.banking.common.exceptions.AccountBlockedException;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;
import com.amrittiwari.banking.common.exceptions.AccountNotFreezedException;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    public Account createAccount(Account account, Address address);
    public Account findAccount(UUID accountNumber);
    public List<Account> findAccountsByName(String name);
    public boolean blockAccount(UUID accountNumber, String referenceNo);
    public boolean unblockAccount(UUID accountNumber, String referenceNo);
    public boolean closeAccount(UUID accountNumber, String referenceNo) ;
    public boolean isAccountNumberValid(UUID accountNumber);
    public boolean doesAccountExistByCitizenshipNumber(String citizenshipNumber);
    public boolean isAccountBlocked(UUID accountNumber);
    public boolean isAccountClosed(UUID accountNumber);

}
