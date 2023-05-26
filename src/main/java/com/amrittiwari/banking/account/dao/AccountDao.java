package com.amrittiwari.banking.account.dao;

import com.amrittiwari.banking.account.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountDao extends JpaRepository<Account, UUID> {
    List<Account> findByAccountNumber(UUID accountNumber);
    List<Account> findByCitizenshipNumber(String citizenshipNumber);

    List<Account> findByName(String name);
}
