package com.example.ald.repository;

import com.example.ald.entities.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AldRepository {

    @Autowired
    @Qualifier("aldJdbcTemplate")
    private JdbcTemplate aldJdbcTemplate;

//    public String test() {
//        return "success";
//    }

    public void testDB() {
        String sql = "Select BORROWER_LEGAL_ENTITY_ID from ALD_PL_APPROVAL where LENDER_LEGAL_ENTITY_ID = 51";
        System.out.println(aldJdbcTemplate.query(sql,new FundRowMapper()));
    }

    class FundRowMapper implements RowMapper {

        @Override
        public Fund mapRow(ResultSet rs, int rowNum) throws SQLException {
            Fund fund = new Fund();
            Integer bId = rs.getInt("BORROWER_LEGAL_ENTITY_ID");
            fund.setBorrowerId(bId);
            return fund;
        }

    }
}
