package com.example.ald.rowmapper;

import com.example.ald.entities.ald.Borrower;
import com.example.ald.entities.ald.Fund;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BorrowerRowMapper implements RowMapper {
    @Override
    public Borrower mapRow(ResultSet rs, int rowNum) throws SQLException {
        Borrower borrower = new Borrower();
        borrower.setFund(new Fund());
        borrower.setBorrowerLegalEntityId(rs.getInt("BORROWER_LEGAL_ENTITY_ID"));
        borrower.setBorrowerTaxId(rs.getString("BORROWER_TAX_ID"));
        borrower.getFund().setFundTaxID(rs.getString("PL_TAX_ID"));
        borrower.getFund().setJurisdiction(rs.getString("PL_COUNTRY_CD"));
        borrower.getFund().setStatus(rs.getString("APPROVAL_STATUS_CD").charAt(0));
        borrower.getFund().setNetAssetValue(rs.getLong("PL_NET_ASSET_VALUE"));
        borrower.getFund().setLendableAsset(rs.getLong("PL_LENDABLE_ASSETS"));
        borrower.getFund().setFundType(rs.getString("CLASSIFICATION_DESC"));
        Timestamp approvalDateTimestamp = rs.getTimestamp("APPROVAL_DT");
        if(approvalDateTimestamp!=null){
            borrower.getFund().setApprovalDate(approvalDateTimestamp.toLocalDateTime());
        }
        Timestamp initiationDateTimestamp = rs.getTimestamp("ENTRY_POST_DTTME");
        if(initiationDateTimestamp!=null){
            borrower.getFund().setInitiationDate(initiationDateTimestamp.toLocalDateTime());
        }
        return borrower;
    }
}
