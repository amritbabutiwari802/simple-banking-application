package com.amrittiwari.banking.account.dao;

import com.amrittiwari.banking.account.models.FreezedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface FreezedAccountDao extends JpaRepository<FreezedAccount, UUID> {
    List<FreezedAccount> findByAccountNumber(UUID accountNumber);
}
