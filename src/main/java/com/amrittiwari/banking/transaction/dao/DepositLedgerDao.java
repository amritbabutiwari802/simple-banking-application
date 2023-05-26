package com.amrittiwari.banking.transaction.dao;

import com.amrittiwari.banking.transaction.models.DepositLedger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepositLedgerDao extends JpaRepository<DepositLedger, UUID> {
}
