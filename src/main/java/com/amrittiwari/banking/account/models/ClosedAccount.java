package com.amrittiwari.banking.account.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "closed_account")
public class ClosedAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(unique = true)
    private String citizenshipNo;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @Column(nullable = false)
    private String grandFatherName;

    @Column(nullable = false)
    private String occupation;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID accountNumber;


    public ClosedAccount() {

    }

    public ClosedAccount(Address address, String citizenshipNo, String name, String fatherName, String motherName, String grandFatherName, String occupation, Account.AccountState accountState) {
        this.address = address;
        this.citizenshipNo = citizenshipNo;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.grandFatherName = grandFatherName;
        this.occupation = occupation;

    }

    public ClosedAccount(Account account){
        this.name = account.getName();
        this.fatherName = account.getFatherName();
        this.motherName = account.getMotherName();
        this.grandFatherName = account.getGrandFatherName();
        this.citizenshipNo= account.getCitizenshipNumber();
        this.accountNumber = account.getAccountNumber();
        this.occupation = account.getOccupation();
        this.address = account.getAddress();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCitizenshipNo() {
        return citizenshipNo;
    }

    public void setCitizenshipNo(String citizenshipNo) {
        this.citizenshipNo = citizenshipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", address=" + address +
                ", citizenshipNo='" + citizenshipNo + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

}
