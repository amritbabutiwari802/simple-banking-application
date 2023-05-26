package com.amrittiwari.banking.account.dto;

public class CreateAccountRequest {
    private Address address;
    private String citizenshipNo;
    private String name;
    private String fatherName;
    private String motherName;
    private String grandFatherName;
    private String occupation;

    public CreateAccountRequest() {
    }

    public CreateAccountRequest(Address address, String citizenshipNo, String name, String fatherName, String motherName, String grandFatherName, String occupation) {
        this.address = address;
        this.citizenshipNo = citizenshipNo;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.grandFatherName = grandFatherName;
        this.occupation = occupation;
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

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                "address=" + address +
                ", citizenshipNo='" + citizenshipNo + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public class Address{
        private String country;
        private String province;
        private String district;
        private String municipality;
        private long postalCode;
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
    }
}
