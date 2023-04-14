package com.example.ald.rowmapper;

import com.example.ald.entities.GridCollDefinition;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollDeffMapper implements RowMapper {

    @Override
    public GridCollDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
        GridCollDefinition gridCollDefinition = new GridCollDefinition();
        gridCollDefinition.setField_Id(rs.getInt("COL_DEF_FIELD_ID"));
        gridCollDefinition.setField_Name(rs.getString("FIELD_NAME"));
        gridCollDefinition.setHeader_Name(rs.getString("HEADER_NAME"));
        gridCollDefinition.setChartDataType(rs.getString("CHART_DATA_TYPE"));
        gridCollDefinition.setCellRenderer(rs.getString("CELL_RENDERER"));
        gridCollDefinition.setSort(rs.getString("SORT"));
        gridCollDefinition.setAggFunc(rs.getString("AGG_FUNC"));
        gridCollDefinition.setEditable(rs.getString("EDITABLE"));
        gridCollDefinition.setCellEditor(rs.getString("CELL_EDITOR"));
        gridCollDefinition.setCellEditorPopup(rs.getString("CELL_EDITOR_POPUP"));
        gridCollDefinition.setCellEditorParams(rs.getString("CELL_EDITOR_PARAMS"));
        gridCollDefinition.setFilter(rs.getString("filter"));
        return gridCollDefinition;
    }
}
