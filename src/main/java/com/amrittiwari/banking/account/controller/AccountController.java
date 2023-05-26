package com.amrittiwari.banking.account.controller;

import com.amrittiwari.banking.account.dao.AccountActionRequest;
import com.amrittiwari.banking.account.dto.CreateAccountRequest;
import com.amrittiwari.banking.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody() CreateAccountRequest createAccountRequest){
        return this.accountService.create(createAccountRequest);
    }

    @PostMapping("/get-account-by-account-number")
    public ResponseEntity getAccountByAccountNumber(@RequestBody() UUID accountNumber){
        return this.accountService.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping("/get-accounts-by-name")
    public ResponseEntity getAccountsByName(@RequestBody() String name){
        return this.accountService.getAccountListByName(name);
    }

    @PostMapping("/is-account-blocked")
    public ResponseEntity isAccountBlocked(@RequestBody() UUID accountNumber){
        return this.accountService.isAccountBlocked(accountNumber);
    }

    @PostMapping("/is-account-closed")
    public ResponseEntity isAccountClosed(@RequestBody() UUID accountNumber){
        return this.accountService.isAccountClosed(accountNumber);
    }

    @PatchMapping("/blockAccount")
    public ResponseEntity blockAccount(@RequestBody()AccountActionRequest accountActionRequest){
        return this.accountService.blockAccount(accountActionRequest);
    }
}
