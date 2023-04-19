package com.example.ald.rowmapper;

import com.example.ald.entities.ald.Fund;
import com.example.ald.entities.ald.Lender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class LenderRowMapper implements RowMapper {
    @Override
    public Lender mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lender lender = new Lender();
        lender.setFund(new Fund());
        lender.setLenderLegalEntityId(rs.getInt("LENDER_LEGAL_ENTITY_ID"));
        lender.setLenderTaxId(rs.getString("LENDER_TAX_ID"));
        lender.getFund().setFundTaxID(rs.getString("PL_TAX_ID"));
        lender.getFund().setJurisdiction(rs.getString("PL_COUNTRY_CD"));
        lender.getFund().setStatus(rs.getString("APPROVAL_STATUS_CD"));
        lender.getFund().setNetAssetValue(rs.getLong("PL_NET_ASSET_VALUE"));
        lender.getFund().setLendableAsset(rs.getLong("PL_LENDABLE_ASSETS"));
        lender.getFund().setFundType(rs.getString("CLASSIFICATION_DESC"));
        Timestamp approvalDateTimestamp = rs.getTimestamp("APPROVAL_DT");
        if(approvalDateTimestamp!=null){
            lender.getFund().setApprovalDate(approvalDateTimestamp.toLocalDateTime());
        }
        Timestamp initiationDateTimestamp = rs.getTimestamp("ENTRY_POST_DTTME");
        if(initiationDateTimestamp!=null){
            lender.getFund().setInitiationDate(initiationDateTimestamp.toLocalDateTime());
        }
        return lender;
    }
}
