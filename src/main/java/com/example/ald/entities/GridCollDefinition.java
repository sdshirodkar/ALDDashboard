package com.example.ald.entities;

public class GridCollDefinition {
  private Integer Field_Id;
  private String Field_Name;
  private String Header_Name;
  private String ChartDataType;
  private String CellRenderer;
  private String Sort;
  private String AggFunc;
  private String Editable;
  private String CellEditor;
  private String CellEditorPopup;
  private String CellEditorParams;


  public Integer getField_Id() {
    return Field_Id;
  }

  public void setField_Id(Integer field_Id) {
    Field_Id = field_Id;
  }

  public String getField_Name() {
    return Field_Name;
  }

  public void setField_Name(String field_Name) {
    Field_Name = field_Name;
  }

  public String getHeader_Name() {
    return Header_Name;
  }

  public void setHeader_Name(String header_Name) {
    Header_Name = header_Name;
  }

  public String getChartDataType() {
    return ChartDataType;
  }

  public void setChartDataType(String chartDataType) {
    ChartDataType = chartDataType;
  }

  public String getCellRenderer() {
    return CellRenderer;
  }

  public void setCellRenderer(String cellRenderer) {
    CellRenderer = cellRenderer;
  }

  public String getSort() {
    return Sort;
  }

  public void setSort(String sort) {
    Sort = sort;
  }

  public String getAggFunc() {
    return AggFunc;
  }

  public void setAggFunc(String aggFunc) {
    AggFunc = aggFunc;
  }

  public String getEditable() {
    return Editable;
  }

  public void setEditable(String editable) {
    Editable = editable;
  }

  public String getCellEditor() {
    return CellEditor;
  }

  public void setCellEditor(String cellEditor) {
    CellEditor = cellEditor;
  }

  public String getCellEditorPopup() {
    return CellEditorPopup;
  }

  public void setCellEditorPopup(String cellEditorPopup) {
    CellEditorPopup = cellEditorPopup;
  }

  public String getCellEditorParams() {
    return CellEditorParams;
  }

  public void setCellEditorParams(String cellEditorParams) {
    CellEditorParams = cellEditorParams;
  }

  @Override
  public String toString() {
    return "GridCollDefinition{" +
            ", Field_Id=" + Field_Id +
            ", Field_Name='" + Field_Name + '\'' +
            ", Header_Name='" + Header_Name + '\'' +
            ", ChartDataType='" + ChartDataType + '\'' +
            ", CellRenderer='" + CellRenderer + '\'' +
            ", Sort='" + Sort + '\'' +
            ", AggFunc='" + AggFunc + '\'' +
            ", Editable='" + Editable + '\'' +
            ", CellEditor='" + CellEditor + '\'' +
            ", CellEditorPopup='" + CellEditorPopup + '\'' +
            ", CellEditorParams='" + CellEditorParams + '\'' +
            '}';
  }
}
