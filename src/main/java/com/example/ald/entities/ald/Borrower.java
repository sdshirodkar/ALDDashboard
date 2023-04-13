package com.example.ald.entities.ald;

public class Borrower {
    private Integer BorrowerLegalEntityId;
    private String BorrowerTaxId;
    private String BorrowerName;

    private Fund fund;

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Integer getBorrowerLegalEntityId() {
        return BorrowerLegalEntityId;
    }

    public void setBorrowerLegalEntityId(Integer borrowerLegalEntityId) {
        BorrowerLegalEntityId = borrowerLegalEntityId;
    }

    public String getBorrowerTaxId() {
        return BorrowerTaxId;
    }

    public void setBorrowerTaxId(String borrowerTaxId) {
        BorrowerTaxId = borrowerTaxId;
    }

    public String getBorrowerName() {
        return BorrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        BorrowerName = borrowerName;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "BorrowerLegalEntityId=" + BorrowerLegalEntityId +
                ", BorrowerTaxId=" + BorrowerTaxId +
                ", BorrowerName='" + BorrowerName + '\'' +
                ", fund=" + fund +
                '}';
    }
}
