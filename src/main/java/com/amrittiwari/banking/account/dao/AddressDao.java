package com.amrittiwari.banking.account.dao;

import com.amrittiwari.banking.account.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressDao extends JpaRepository<Address, UUID> {
}
