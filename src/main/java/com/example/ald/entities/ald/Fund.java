package com.example.ald.entities.ald;

import java.time.LocalDateTime;

public class Fund {

    private String FundTaxID;
    private String FundType;
    private String Jurisdiction;
    private Long NetAssetValue;
    private Long LendableAsset;
    private Character Status;
    private LocalDateTime ApprovalDate;
    private LocalDateTime InitiationDate;

    public String getFundTaxID() { return FundTaxID; }

    public void setFundTaxID(String fundTaxID) {
        FundTaxID = fundTaxID;
    }

    public String getFundType() {
        return FundType;
    }

    public void setFundType(String fundType) {
        FundType = fundType;
    }

    public String getJurisdiction() {
        return Jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        Jurisdiction = jurisdiction;
    }

    public Long getNetAssetValue() {
        return NetAssetValue;
    }

    public void setNetAssetValue(Long netAssetValue) {
        NetAssetValue = netAssetValue;
    }

    public Long getLendableAsset() {
        return LendableAsset;
    }

    public void setLendableAsset(Long lendableAsset) {
        LendableAsset = lendableAsset;
    }

    public Character getStatus() {
        return Status;
    }

    public void setStatus(Character status) {
        Status = status;
    }

    public LocalDateTime getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        ApprovalDate = approvalDate;
    }

    public LocalDateTime getInitiationDate() {
        return InitiationDate;
    }

    public void setInitiationDate(LocalDateTime initiationDate) {
        InitiationDate = initiationDate;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "FundTaxID=" + FundTaxID +
                ", FundType='" + FundType + '\'' +
                ", Jurisdiction='" + Jurisdiction + '\'' +
                ", NetAssetValue=" + NetAssetValue +
                ", LendableAsset=" + LendableAsset +
                ", Status=" + Status +
                ", ApprovalDate=" + ApprovalDate +
                ", InitiationDate=" + InitiationDate +
                '}';
    }
}
