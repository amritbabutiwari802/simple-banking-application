package com.amrittiwari.banking.account.dao;

import com.amrittiwari.banking.account.models.ClosedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClosedAccountDao extends JpaRepository<ClosedAccount, UUID> {

    List<ClosedAccount> findByAccountNumber(UUID accountNumber);
}
