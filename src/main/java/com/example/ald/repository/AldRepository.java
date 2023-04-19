package com.example.ald.repository;

import com.example.ald.entities.GridCollDefinition;
import com.example.ald.entities.ald.Borrower;
import com.example.ald.entities.ald.Lender;
import com.example.ald.rowmapper.BorrowerRowMapper;
import com.example.ald.rowmapper.CollDeffMapper;
import com.example.ald.rowmapper.LenderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class AldRepository {

    @Autowired
    @Qualifier("aldJdbcTemplate")
    private JdbcTemplate aldJdbcTemplate;


    //Column Definition
    public List<GridCollDefinition> getCollDeffData(String collDefFieldIds){

        StringBuilder sbsql= new StringBuilder("select * from SDSHIRODKAR.ALD_GRID_COL_DEFS WHERE COL_DEF_FIELD_ID IN (");
        sbsql.append(collDefFieldIds+")");
        List<GridCollDefinition> collDeffData = aldJdbcTemplate.query(sbsql.toString(), new CollDeffMapper());
        System.out.println(collDeffData);
        return collDeffData;

    }

    public String getCollDefFieldIds(){
        String sql = "SELECT COL_DEF_FIELD_ID FROM SDSHIRODKAR.LE_COL_DEF_MAPPING WHERE ORG_ID = 23";
        String colDeffFields = aldJdbcTemplate.query(sql, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("COL_DEF_FIELD_ID");
                    }
                }).toString();

        System.out.println(colDeffFields);
        return colDeffFields;

    }

    // Passing empty value for COL_DEF_FIELD_ID to set default values
    public void insertCollDeffData() {
        Integer orgId = 5;
        String sql = "INSERT INTO SDSHIRODKAR.LE_COL_DEF_MAPPING (ORG_ID, COL_DEF_FIELD_ID) VALUES("+orgId+", '')" ;
        aldJdbcTemplate.update(sql);
    }

    // Getting all LegalEntity Ids for a org
    public  List<Integer> getAllLeIdsForOrg(Integer orgId) {
        String sql = "SELECT LEGAL_ENTITY_ID  FROM LEGAL_ENTITY  WHERE  ORG_ID = "+orgId;
        List<Integer> AllLEList = aldJdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("LEGAL_ENTITY_ID");
            }
        });
        return AllLEList;
    }

    public List<Borrower> getAldFundDataforLenderLE(Integer legalEntityId) {
        String sql = "SELECT a.BORROWER_LEGAL_ENTITY_ID, a.BORROWER_TAX_ID, a.PL_TAX_ID, a.PL_COUNTRY_CD, a.PL_NET_ASSET_VALUE, " +
                "a.PL_LENDABLE_ASSETS, c.CLASSIFICATION_DESC,a.APPROVAL_STATUS_CD, a.APPROVAL_DT, a.ENTRY_POST_DTTME " +
                "FROM ALD_PL_APPROVAL a INNER JOIN CLASSIFICATION c ON a.PL_CLASSIFICATION_CD = c.CLASSIFICATION_CD " +
                "WHERE a.LENDER_LEGAL_ENTITY_ID = "+legalEntityId+" AND a.PL_CLASSIFICATION_CD IS NOT NULL";

//        String sql = "SELECT  o.ORG_NAME, a.BORROWER_LEGAL_ENTITY_ID, a.BORROWER_TAX_ID, a.PL_TAX_ID, a.PL_COUNTRY_CD, a.PL_NET_ASSET_VALUE, a.PL_LENDABLE_ASSETS, \n" +
//                " a.APPROVAL_STATUS_CD, a.APPROVAL_DT, a.ENTRY_POST_DTTME, c.CLASSIFICATION_DESC\n" +
//                "FROM ALD_PL_APPROVAL a \n" +
//                "INNER JOIN CLASSIFICATION c ON a.PL_CLASSIFICATION_CD = c.CLASSIFICATION_CD \n" +
//                "INNER JOIN LEGAL_ENTITY le ON a.LENDER_LEGAL_ENTITY_ID = le.LEGAL_ENTITY_ID \n" +
//                "INNER JOIN ORGANIZATION o ON le.ORG_ID = o.ORG_ID \n" +
//                "WHERE a.LENDER_LEGAL_ENTITY_ID = 51 AND a.PL_CLASSIFICATION_CD IS NOT NULL";

        List<Borrower> aldDataforLenderLE = aldJdbcTemplate.query(sql,new BorrowerRowMapper());
        return aldDataforLenderLE;
    }

    public List<Lender> getAldFundDataforBorrowerLE(Integer legalEntityId) {
        String sql = "SELECT a.LENDER_LEGAL_ENTITY_ID, a.LENDER_TAX_ID, a.PL_TAX_ID, a.PL_COUNTRY_CD, a.PL_NET_ASSET_VALUE, " +
                "a.PL_LENDABLE_ASSETS, c.CLASSIFICATION_DESC,a.APPROVAL_STATUS_CD, a.APPROVAL_DT, a.ENTRY_POST_DTTME " +
                "FROM ALD_PL_APPROVAL a INNER JOIN CLASSIFICATION c ON a.PL_CLASSIFICATION_CD = c.CLASSIFICATION_CD " +
                "WHERE a.BORROWER_LEGAL_ENTITY_ID = "+legalEntityId+" AND a.PL_CLASSIFICATION_CD IS NOT NULL";


        List<Lender> aldDataforBorrowerLE = aldJdbcTemplate.query(sql,new LenderRowMapper());
        return aldDataforBorrowerLE;
    }

    public String getOrgNameForLEID(Integer legalEntityID) {
        String sql = "SELECT o.ORG_NAME FROM ORGANIZATION o JOIN LEGAL_ENTITY le ON o.ORG_ID = le.ORG_ID " +
                "WHERE le.LEGAL_ENTITY_ID = "+legalEntityID;
        String orgName = aldJdbcTemplate.query(sql,new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("ORG_NAME");
            }
        }).toString();

        return orgName;

    }
}
