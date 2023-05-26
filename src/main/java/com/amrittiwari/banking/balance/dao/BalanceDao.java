package com.amrittiwari.banking.balance.dao;

import com.amrittiwari.banking.balance.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BalanceDao extends JpaRepository<Balance, UUID> {
    List<Balance> findByAccountNumber(UUID accountNumber);
}
