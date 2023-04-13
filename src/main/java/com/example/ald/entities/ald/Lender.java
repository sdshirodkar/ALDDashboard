package com.example.ald.entities.ald;

public class Lender {

    private Integer LenderLegalEntityId;
    private Integer LenderTaxId;
    private String LenderName;

    private Fund fund;

    public Integer getLenderLegalEntityId() {
        return LenderLegalEntityId;
    }

    public void setLenderLegalEntityId(Integer lenderLegalEntityId) {
        LenderLegalEntityId = lenderLegalEntityId;
    }

    public Integer getLenderTaxId() {
        return LenderTaxId;
    }

    public void setLenderTaxId(Integer lenderTaxId) {
        LenderTaxId = lenderTaxId;
    }

    public String getLenderName() {
        return LenderName;
    }

    public void setLenderName(String lenderName) {
        LenderName = lenderName;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "LenderLegalEntityId=" + LenderLegalEntityId +
                ", LenderTaxId=" + LenderTaxId +
                ", LenderName='" + LenderName + '\'' +
                ", fund=" + fund +
                '}';
    }
}
