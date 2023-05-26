package com.amrittiwari.banking.account.service;

import com.amrittiwari.banking.account.dao.AccountActionRequest;
import com.amrittiwari.banking.account.dao.AccountBlockedResponse;
import com.amrittiwari.banking.account.dao.AccountClosedResponse;
import com.amrittiwari.banking.account.dto.CreateAccountRequest;
import com.amrittiwari.banking.account.dto.CreateAccountResponse;
import com.amrittiwari.banking.account.models.Account;
import com.amrittiwari.banking.account.models.Address;
import com.amrittiwari.banking.account.repository.interfaces.AccountRepository;
import com.amrittiwari.banking.balance.repository.interfaces.BalanceRepository;
import com.amrittiwari.banking.common.entities.Money;
import com.amrittiwari.banking.transaction.repository.interfaces.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, BalanceRepository balanceRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public ResponseEntity create(CreateAccountRequest createAccountRequest){
        boolean doesAccountExistByCitizenshipNumber = this.accountRepository.doesAccountExistByCitizenshipNumber(createAccountRequest.getCitizenshipNo());
        if(doesAccountExistByCitizenshipNumber){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "account already exists by citizenship number");
        }
        Address address = new Address();
        CreateAccountRequest.Address address1 = createAccountRequest.getAddress();
        address.setCountry(address1.getCountry());
        address.setProvince(address1.getProvince());
        address.setDistrict(address1.getDistrict());
        address.setLocalAddress(address1.getLocalAddress());
        address.setMunicipality(address1.getMunicipality());
        address.setPostalCode(address1.getPostalCode());
        Account temp = new Account();
        temp.setName(createAccountRequest.getName());
        temp.setCitizenshipNumber(createAccountRequest.getCitizenshipNo());
        temp.setFatherName(createAccountRequest.getFatherName());
        temp.setMotherName(createAccountRequest.getMotherName());
        temp.setGrandFatherName(createAccountRequest.getGrandFatherName());
        temp.setOccupation(createAccountRequest.getOccupation());
        temp.setAccountState(Account.AccountState.UN_BLOCKED);
        Account accountCreated = this.accountRepository.createAccount(temp, address);
        this.balanceRepository.initialize(accountCreated.getAccountNumber());
        Money money = new Money.Builder()
                .withAmountInRupees(0)
                .withAmountInPaisa(0)
                .build();
        this.transactionRepository.writeDeposit(accountCreated.getAccountNumber(), money, "account Created");
        return ResponseEntity.ok().body(new CreateAccountResponse(accountCreated.getAccountNumber()));
    }

    public ResponseEntity getAccountByAccountNumber(UUID accountNumber){
       validateAccoutNumber(accountNumber);
        Account account = this.accountRepository.findAccount(accountNumber);
        return ResponseEntity.ok().body(account);
    }

    public ResponseEntity getAccountListByName(String name){
        List<Account> accountList = this.accountRepository.findAccountsByName(name);
        return ResponseEntity.ok().body(accountList);
    }

    public ResponseEntity isAccountClosed(UUID accountNumber){
        boolean isAccountClosed = this.accountRepository.isAccountClosed(accountNumber);
        AccountClosedResponse accountClosedResponse = new AccountClosedResponse();
        if(isAccountClosed){
            accountClosedResponse.setAccountClosed(true);
        }else{
            accountClosedResponse.setAccountClosed(false);
        }
        return ResponseEntity.ok().body(accountClosedResponse);
    }

    public ResponseEntity isAccountBlocked(UUID accountNumber){
        validateAccoutNumber(accountNumber);
        boolean isAccountBlocked = this.accountRepository.isAccountBlocked(accountNumber);
        AccountBlockedResponse accountBlockedResponse = new AccountBlockedResponse();
        if(isAccountBlocked){
            accountBlockedResponse.setAccountBlocked(true);
        }else{
            accountBlockedResponse.setAccountBlocked(false);
        }
        return ResponseEntity.ok().body(accountBlockedResponse);
    }

    @Transactional
    public ResponseEntity blockAccount(AccountActionRequest accountActionRequest){
    validateAccoutNumber(accountActionRequest.getAccountNumber());
    this.accountRepository.blockAccount(accountActionRequest.getAccountNumber(), accountActionRequest.getReferenceNo());
    this.balanceRepository.freezeBalance(accountActionRequest.getAccountNumber());
    return ResponseEntity.ok().body(true);
    }

    void validateAccoutNumber(UUID accountNumber){
        if(!this.accountRepository.isAccountNumberValid(accountNumber)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "account number is not valid");
        }
    }
}
