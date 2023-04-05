package com.example.ald.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.ald.entities.Fund;
import com.example.ald.entities.GridCollDefinition;
import com.example.ald.rowmapper.CollDeffMapper;
import com.example.ald.rowmapper.FundRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AldRepository {

    @Autowired
    @Qualifier("aldJdbcTemplate")
    private JdbcTemplate aldJdbcTemplate;

    public List<GridCollDefinition> getCollDeffData(ArrayList<Integer> collDefArray){
       String sql = "select * from SDSHIRODKAR.ALD_GRID_COL_DEFS WHERE COL_DEF_FIELD_ID IN (";
        for(int i =0;i<collDefArray.size()-1;i++){
            sql = sql + collDefArray.get(i) + ",";
        }
        sql = sql + collDefArray.get(collDefArray.size()-1) + ")";


        List<GridCollDefinition> collDeffData = aldJdbcTemplate.query(sql, new CollDeffMapper());
        System.out.println(collDeffData);
        return collDeffData;

    }

    public String getCollDefFieldIds(){
        String sql = "SELECT COL_DEF_FIELD_ID FROM SDSHIRODKAR.LE_COL_DEF_MAPPING WHERE ORG_ID = 22";
        String colDeffFields = aldJdbcTemplate.query(sql, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("COL_DEF_FIELD_ID");
                    }
                }).toString();

        System.out.println(colDeffFields);
        return colDeffFields;

    }

//    public void testDB() {
//        String sql = "Select BORROWER_LEGAL_ENTITY_ID from ALD_PL_APPROVAL where LENDER_LEGAL_ENTITY_ID = 51";
//        System.out.println(aldJdbcTemplate.query(sql,new FundRowMapper()));
//    }

}
