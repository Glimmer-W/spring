package com.wl.domain;

public class Company {
    /**
     * 公司编号
     */
    private int id;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司建账年月
     */
    private String buildAccountDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildAccountDate() {
        return buildAccountDate;
    }

    public void setBuildAccountDate(String buildAccountDate) {
        this.buildAccountDate = buildAccountDate;
    }
}
