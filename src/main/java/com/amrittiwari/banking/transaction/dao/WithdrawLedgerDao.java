package com.amrittiwari.banking.transaction.dao;

import com.amrittiwari.banking.transaction.models.WithdrawLedger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WithdrawLedgerDao extends JpaRepository<WithdrawLedger, UUID> {
}
