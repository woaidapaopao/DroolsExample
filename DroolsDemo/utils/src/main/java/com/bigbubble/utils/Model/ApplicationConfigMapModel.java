package com.bigbubble.utils.Model;

import java.util.List;
/*
   应用配置映射模型
 */
public class ApplicationConfigMapModel implements IConfigMapModel {
    private String name;
    private String tableId;
    private String appId;
    private List<ApplicationColumn> applicationColumns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public List<ApplicationColumn> getApplicationColumns() {
        return applicationColumns;
    }

    public void setApplicationColumns(List<ApplicationColumn> applicationColumns) {
        this.applicationColumns = applicationColumns;
    }

    public String getAppId() {
        return appId;
    }

    @Override
    public String toString() {
        return "ApplicationConfigMapModel{" +
                "name='" + name + '\'' +
                ", tableId='" + tableId + '\'' +
                ", appId='" + appId + '\'' +
                ", applicationColumns=" + applicationColumns +
                '}';
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}
