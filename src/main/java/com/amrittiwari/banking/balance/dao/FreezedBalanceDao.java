package com.amrittiwari.banking.balance.dao;

import com.amrittiwari.banking.balance.models.FreezedBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FreezedBalanceDao extends JpaRepository<FreezedBalance, UUID> {
    List<FreezedBalance> findByAccountNumber(UUID accountNumber);
}
