package com.amrittiwari.banking.transaction.controller;

import com.amrittiwari.banking.transaction.dto.DepositRequest;
import com.amrittiwari.banking.transaction.dto.TransferRequest;
import com.amrittiwari.banking.transaction.dto.WithdrawRequest;
import com.amrittiwari.banking.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/transaction")
public class TransferController {

    private final TransactionService transactionService;

    public TransferController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody() DepositRequest depositRequest){
        return this.transactionService.deposit(depositRequest);
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody() WithdrawRequest withdrawRequest){
        return this.transactionService.withdraw(withdrawRequest);
    }

    @PostMapping("/transfer")
    public ResponseEntity transfer(@RequestBody() TransferRequest transferRequest){
        return this.transactionService.transfer(transferRequest);
    }
}
