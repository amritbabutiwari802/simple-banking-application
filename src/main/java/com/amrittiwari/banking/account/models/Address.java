package com.amrittiwari.banking.account.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String municipality;

    @Column(nullable = false)
    private long postalCode;

    @Column(nullable = false)
    private String localAddress;

    public Address() {
    }

    public Address(String country, String province, String district, String municipality, long postalCode, String localAddress) {
        this.country = country;
        this.province = province;
        this.district = district;
        this.municipality = municipality;
        this.postalCode = postalCode;
        this.localAddress = localAddress;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", municipality='" + municipality + '\'' +
                ", postalCode=" + postalCode +
                ", localAddress='" + localAddress + '\'' +
                '}';
    }
}
