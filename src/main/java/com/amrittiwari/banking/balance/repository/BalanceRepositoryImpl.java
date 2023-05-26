package com.amrittiwari.banking.balance.repository;

import com.amrittiwari.banking.balance.dao.BalanceDao;
import com.amrittiwari.banking.balance.dao.FreezedBalanceDao;
import com.amrittiwari.banking.balance.repository.interfaces.BalanceRepository;
import com.amrittiwari.banking.balance.models.Balance;
import com.amrittiwari.banking.balance.models.FreezedBalance;
import com.amrittiwari.banking.common.exceptions.AccountNotFreezedException;
import com.amrittiwari.banking.balance.utils.BalanceUtil;
import com.amrittiwari.banking.balance.utils.SubstractException;
import com.amrittiwari.banking.common.entities.Money;
import com.amrittiwari.banking.common.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    private final BalanceDao balanceDao;
    private final FreezedBalanceDao freezedBalanceDao;

    public BalanceRepositoryImpl(BalanceDao balanceDao, FreezedBalanceDao freezedBalanceDao) {
        this.balanceDao = balanceDao;
        this.freezedBalanceDao = freezedBalanceDao;
    }

    @Override
    public Balance initialize(UUID accountNumber) {
        Balance balance = new Balance();
        balance.setAccountNumber(accountNumber);
        balance.setAmountInRupees(0);
        balance.setAmountInPaisa(0);
        Balance balanceCreated = this.balanceDao.save(balance);
        return balanceCreated;
    }

    @Override
    public Balance deposit(UUID accountNumber, Money addend) {
        List<Balance> result = this.balanceDao.findByAccountNumber(accountNumber);
        Balance currentBalance = result.get(0);
        Money currentAmountInDatabase = new Money.Builder()
                .withAmountInPaisa(currentBalance.getAmountInPaisa())
                .withAmountInRupees(currentBalance.getAmountInRupees())
                .build();
        Money sum = BalanceUtil.addMoney(currentAmountInDatabase, addend);
        currentBalance.setAmountInRupees(sum.getAmountInRupees());
        currentBalance.setAmountInPaisa(sum.getAmountInPaisa());
        this.balanceDao.save(currentBalance);
        return currentBalance;
    }

    @Override
    public Balance withdraw(UUID accountNumber, Money substractend) throws  SubstractException {
        List<Balance> result = this.balanceDao.findByAccountNumber(accountNumber);
        Balance currentBalance = result.get(0);
        Money currentAmountInDatabase = new Money.Builder()
                .withAmountInPaisa(currentBalance.getAmountInPaisa())
                .withAmountInRupees(currentBalance.getAmountInRupees())
                .build();

        Money newBalance = BalanceUtil.substractMoney(currentAmountInDatabase, substractend);

        currentBalance.setAmountInRupees(newBalance.getAmountInRupees());
        currentBalance.setAmountInPaisa(newBalance.getAmountInPaisa());
        this.balanceDao.save(currentBalance);
        return currentBalance;
    }

    @Override
    public boolean freezeBalance(UUID accountNumber)  {
        List<Balance> list = this.balanceDao.findByAccountNumber(accountNumber);
        Balance currentBalance = list.get(0);
        List<FreezedBalance> freezedBalanceList = this.freezedBalanceDao.findByAccountNumber(accountNumber);
        FreezedBalance freezedBalance = null;
        if(freezedBalanceList.size()==0){
            freezedBalance = new FreezedBalance();
            freezedBalance.setAccountNumber(accountNumber);
        }else{
            freezedBalance = freezedBalanceList.get(0);
        }
        freezedBalance.setAmountInRupees(currentBalance.getAmountInRupees());
        freezedBalance.setAmountInPaisa(currentBalance.getAmountInPaisa());
        currentBalance.setAmountInPaisa(0);
        currentBalance.setAmountInRupees(0);
        this.balanceDao.save(currentBalance);
        this.freezedBalanceDao.save(freezedBalance);
        return true;
    }

    @Override
    public boolean unfreezeBalance(UUID accountNumber)  {
        List<Balance> list = this.balanceDao.findByAccountNumber(accountNumber);
        Balance currentBalance = list.get(0);
        List<FreezedBalance> freezedBalanceList = this.freezedBalanceDao.findByAccountNumber(accountNumber);
        FreezedBalance freezedBalance = null;
        freezedBalance = freezedBalanceList.get(0);
        currentBalance.setAmountInPaisa(freezedBalance.getAmountInPaisa());
        currentBalance.setAmountInRupees(freezedBalance.getAmountInRupees());
        freezedBalance.setAmountInRupees(0);
        freezedBalance.setAmountInPaisa(0);
        this.balanceDao.save(currentBalance);
        this.freezedBalanceDao.save(freezedBalance);
        return true;
    }

    @Override
    public boolean close(UUID accuntNumber) {
        List<Balance> balanceList = this.balanceDao.findByAccountNumber(accuntNumber);
        if(balanceList.size()==1){
            Balance balance = balanceList.get(0);
            this.balanceDao.delete(balance);
            return true;
        }
        return false;
    }
}
