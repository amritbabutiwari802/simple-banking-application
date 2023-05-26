package com.amrittiwari.banking.transaction.service;

import com.amrittiwari.banking.account.repository.interfaces.AccountRepository;
import com.amrittiwari.banking.balance.repository.interfaces.BalanceRepository;
import com.amrittiwari.banking.balance.utils.SubstractException;
import com.amrittiwari.banking.transaction.dto.DepositRequest;
import com.amrittiwari.banking.transaction.dto.TransferRequest;
import com.amrittiwari.banking.transaction.dto.WithdrawRequest;
import com.amrittiwari.banking.transaction.repository.interfaces.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, BalanceRepository balanceRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public ResponseEntity deposit(DepositRequest depositRequest){
        validateAccountNumber(depositRequest.getAccountNumber());
        validateAccountActiveness(depositRequest.getAccountNumber());
        this.balanceRepository.deposit(depositRequest.getAccountNumber(), depositRequest.getMoney());
        this.transactionRepository.writeDeposit(depositRequest.getAccountNumber(), depositRequest.getMoney(), depositRequest.getRemarks());
        return ResponseEntity.ok().body(true);
    }

    @Transactional
    public ResponseEntity withdraw(WithdrawRequest withdrawRequest){
        try {
            validateAccountNumber(withdrawRequest.getAccountNumber());
            validateAccountActiveness(withdrawRequest.getAccountNumber());
            this.balanceRepository.withdraw(withdrawRequest.getAccountNumber(), withdrawRequest.getMoney());
            this.transactionRepository.writeWithdraw(withdrawRequest.getAccountNumber(), withdrawRequest.getMoney(), withdrawRequest.getRemarks());
            return ResponseEntity.ok().body(true);
        }catch (SubstractException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sufficient funds are not available in account");
        }
    }

    @Transactional
    public ResponseEntity transfer(TransferRequest transferRequest){
        try {
            validateAccountNumber(transferRequest.getFrom());
            validateAccountNumber(transferRequest.getTo());
            validateAccountActiveness(transferRequest.getFrom());
            validateAccountActiveness(transferRequest.getTo());
            this.balanceRepository.withdraw(transferRequest.getFrom(), transferRequest.getMoney());
            this.balanceRepository.deposit(transferRequest.getTo(), transferRequest.getMoney());
            this.transactionRepository.writeTransfer(transferRequest.getFrom(), transferRequest.getTo(), transferRequest.getMoney(), transferRequest.getRemarks());
            return ResponseEntity.ok().body(true);
        } catch (SubstractException substractException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sufficient funds not available in sender account");
        }
    }

    void validateAccountNumber(UUID accountNumber){
        boolean isAccountNumberValid = this.accountRepository.isAccountBlocked(accountNumber);
        if(!isAccountNumberValid){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "account number not valid: " + accountNumber );
        }
    }

    void validateAccountActiveness(UUID accountNumber){
        boolean isAccountBlocked = this.accountRepository.isAccountBlocked(accountNumber);
        if(isAccountBlocked){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "account number is blocked: " + accountNumber);
        }
    }

}
