package com.amrittiwari.banking.account.repository;

import com.amrittiwari.banking.account.dao.AccountDao;
import com.amrittiwari.banking.account.dao.FreezedAccountDao;
import com.amrittiwari.banking.account.dao.ClosedAccountDao;
import com.amrittiwari.banking.account.repository.interfaces.AccountRepository;
import com.amrittiwari.banking.account.models.Account;
import com.amrittiwari.banking.account.models.Address;
import com.amrittiwari.banking.account.models.ClosedAccount;
import com.amrittiwari.banking.account.models.FreezedAccount;
import com.amrittiwari.banking.common.exceptions.AccountAlreadyFreezedException;
import com.amrittiwari.banking.common.exceptions.AccountBlockedException;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;
import com.amrittiwari.banking.common.exceptions.AccountNotFreezedException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccountResositoryImpl implements AccountRepository {

    private final AccountDao accountDao;
    private final FreezedAccountDao freezedAccountDao;
    private final ClosedAccountDao closedAccountDao;


    public AccountResositoryImpl(AccountDao accountDao, FreezedAccountDao freezedAccountDao, ClosedAccountDao closedAccountDao) {
        this.accountDao = accountDao;
        this.freezedAccountDao = freezedAccountDao;
        this.closedAccountDao = closedAccountDao;
    }

    @Override
    public Account createAccount(Account account, Address address) {
        account.setAddress(address);
        Account createdAccount = this.accountDao.save(account);
        return createdAccount;
    }

    @Override
    public Account findAccount(UUID accountNumber) {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        return accountList.get(0);
    }

    @Override
    public List<Account> findAccountsByName(String name) {
        List<Account> accountList = this.accountDao.findByName(name);
        return accountList;
    }

    @Override
    public boolean blockAccount(UUID accountNumber, String referenceNumber)  {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        Account account = accountList.get(0);
        account.setAccountState(Account.AccountState.BLOCKED);
        FreezedAccount freezedAccount = new FreezedAccount();
        freezedAccount.setAccountNumber(accountNumber);
        freezedAccount.setReferenceNo(referenceNumber);
        this.accountDao.save(account);
        this.freezedAccountDao.save(freezedAccount);
        return true;
    }

    @Override
    public boolean unblockAccount(UUID accountNumber, String referenceNo) {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        List<FreezedAccount> freezedAccountList = this.freezedAccountDao.findByAccountNumber(accountNumber);
        Account account = accountList.get(0);
        FreezedAccount freezedAccount = freezedAccountList.get(0);
        account.setAccountState(Account.AccountState.UN_BLOCKED);
        this.accountDao.save(account);
        this.freezedAccountDao.delete(freezedAccount);
        return true;
    }

    @Override
    public boolean closeAccount(UUID accountNumber, String referenceNo) {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        Account account = accountList.get(0);
        ClosedAccount closedAccount = new ClosedAccount(account);
        this.closedAccountDao.save(closedAccount);
        this.accountDao.delete(account);
        return false;
    }

    @Override
    public boolean isAccountNumberValid(UUID accountNumber) {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        if(accountList.size()==0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean doesAccountExistByCitizenshipNumber(String citizenshipNumber) {
        List<Account> accountList = this.accountDao.findByCitizenshipNumber(citizenshipNumber);
        if(accountList.size()==0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAccountBlocked(UUID accountNumber) {
        List<Account> accountList = this.accountDao.findByAccountNumber(accountNumber);
        Account account = accountList.get(0);
        if(account.getAccountState()== Account.AccountState.BLOCKED){
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccountClosed(UUID accountNumber) {
        List<ClosedAccount> closedAccountList = this.closedAccountDao.findByAccountNumber(accountNumber);
        if(closedAccountList.size()==1){
            return true;
        }
        return false;
    }
}
