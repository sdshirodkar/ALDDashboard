package com.example.ald.repository;

import com.example.ald.entities.CPRDemo;
import com.example.ald.entities.Fund;
import com.example.ald.entities.SecurityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DLRepository {

    @Autowired
    @Qualifier("dlJdbcTemplate")
    private JdbcTemplate dlJdbcTemplate;

    @Autowired
    @Qualifier("cprJdbcTemplate")
    private JdbcTemplate cprJdbcTemplate;


    public void testDB(){
        String sql = "SELECT ISIN  FROM MD_SECURITY WHERE MD_SECURITY_ID =8482860";
        System.out.println(dlJdbcTemplate.query(sql, new SecurityRowMapper()));
    }
    public void testCPRDB(){
        String sql = "SELECT COLLATERAL_TYPE_CD  FROM CPR_ENTITY WHERE ENTITY_ID = 255939";
        System.out.println(cprJdbcTemplate.query(sql, new CPRRowMapper()));
    }


    class CPRRowMapper implements RowMapper {

        @Override
        public CPRDemo mapRow(ResultSet rs, int rowNum) throws SQLException {
            CPRDemo cpr = new CPRDemo();
            String collateral = rs.getString("COLLATERAL_TYPE_CD");
            cpr.setCollateralType(collateral);
            return cpr;
        }

    }
    class SecurityRowMapper implements RowMapper {

        @Override
        public SecurityInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            SecurityInfo securityInfo = new SecurityInfo();
            String isin = rs.getString("ISIN");
            securityInfo.setIsin(isin);
            return securityInfo;
        }

    }



}
