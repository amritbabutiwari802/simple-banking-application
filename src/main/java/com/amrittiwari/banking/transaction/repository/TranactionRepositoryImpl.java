package com.amrittiwari.banking.transaction.repository;

import com.amrittiwari.banking.account.dao.AccountDao;
import com.amrittiwari.banking.account.models.Account;
import com.amrittiwari.banking.common.entities.Money;
import com.amrittiwari.banking.common.exceptions.AccountBlockedException;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;
import com.amrittiwari.banking.transaction.dao.DepositLedgerDao;
import com.amrittiwari.banking.transaction.dao.WithdrawLedgerDao;
import com.amrittiwari.banking.transaction.models.DepositLedger;
import com.amrittiwari.banking.transaction.models.WithdrawLedger;
import com.amrittiwari.banking.transaction.repository.interfaces.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TranactionRepositoryImpl implements TransactionRepository {

    private final AccountDao accountDao;
    private final DepositLedgerDao depositLedgerDao;
    private final WithdrawLedgerDao withdrawLedgerDao;

    public TranactionRepositoryImpl(AccountDao accountDao, DepositLedgerDao depositLedgerDao, WithdrawLedgerDao withdrawLedgerDao) {
        this.accountDao = accountDao;
        this.depositLedgerDao = depositLedgerDao;
        this.withdrawLedgerDao = withdrawLedgerDao;
    }

    @Override
    public boolean writeDeposit(UUID accountNumber, Money money, String remarks)  {
        DepositLedger depositLedger = new DepositLedger();
        depositLedger.setAccountNumber(accountNumber);
        depositLedger.setAmountInRupees(money.getAmountInRupees());
        depositLedger.setAmountInPaisa(money.getAmountInRupees());
        depositLedger.setTransactionType(DepositLedger.TransactionType.DEPOSIT);
        depositLedger.setRemarks(remarks);
        this.depositLedgerDao.save(depositLedger);
        return true;
    }

    @Override
    public boolean writeWithdraw(UUID accountNumber, Money money, String remarks) {
        WithdrawLedger withdrawLedger = new WithdrawLedger();
        withdrawLedger.setAccountNumber(accountNumber);
        withdrawLedger.setAmountInRupees(money.getAmountInRupees());
        withdrawLedger.setAmountInPaisa(money.getAmountInPaisa());
        withdrawLedger.setTransactionType(WithdrawLedger.TransactionType.WITHDRAW);
        withdrawLedger.setRemarks(remarks);
        this.withdrawLedgerDao.save(withdrawLedger);
        return true;
    }

    @Override
    public boolean writeTransfer(UUID from, UUID to, Money money, String remarks) {
        DepositLedger depositLedger = new DepositLedger();
        depositLedger.setAccountNumber(from);
        depositLedger.setAmountInRupees(money.getAmountInRupees());
        depositLedger.setAmountInPaisa(money.getAmountInRupees());
        depositLedger.setTransactionType(DepositLedger.TransactionType.TRANSFER);
        depositLedger.setRemarks(remarks);
        WithdrawLedger withdrawLedger = new WithdrawLedger();
        withdrawLedger.setAccountNumber(to);
        withdrawLedger.setAmountInRupees(money.getAmountInRupees());
        withdrawLedger.setAmountInPaisa(money.getAmountInPaisa());
        withdrawLedger.setTransactionType(WithdrawLedger.TransactionType.TRANSFER);
        withdrawLedger.setRemarks(remarks);
        WithdrawLedger withdrawLedgerWithId = this.withdrawLedgerDao.save(withdrawLedger);
        DepositLedger depositLedgerWithId = this.depositLedgerDao.save(depositLedger);
        depositLedgerWithId.setWithdrawId(withdrawLedgerWithId.getId());
        withdrawLedgerWithId.setDepositId(depositLedgerWithId.getId());
        this.depositLedgerDao.save(depositLedgerWithId);
        this.withdrawLedgerDao.save(withdrawLedgerWithId);
        return true;
    }
}
