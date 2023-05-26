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
//    import jakarta.validation.constraints.Pattern;
   //     import     jakarta.validation.constraints.Size;
        import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(unique = true)
    private String citizenshipNumber;

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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID accountNumber;

    private AccountState accountState;

    public Account() {

    }

    public Account(Address address, String citizenshipNo, String name, String fatherName, String motherName, String grandFatherName, String occupation, AccountState accountState) {
        this.address = address;
        this.citizenshipNumber = citizenshipNo;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.grandFatherName = grandFatherName;
        this.occupation = occupation;
        this.accountState = accountState;
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

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
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
                ", citizenshipNo='" + citizenshipNumber + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public enum AccountState{
        BLOCKED,
        UN_BLOCKED;
    }
}
