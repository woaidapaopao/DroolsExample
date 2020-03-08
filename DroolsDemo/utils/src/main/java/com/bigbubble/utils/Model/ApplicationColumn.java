package com.bigbubble.utils.Model;

public class ApplicationColumn {
    private String dataType;
    private boolean incrementValue;
    private String columnName;
    private String type;

    @Override
    public String toString() {
        return "ApplicationColumnsModel{" +
                "dataType='" + dataType + '\'' +
                ", incrementValue=" + incrementValue +
                ", columnName='" + columnName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(boolean incrementValue) {
        this.incrementValue = incrementValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
