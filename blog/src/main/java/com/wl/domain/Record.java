package com.wl.domain;

public class Record {
    private int id;
    private int companyId;
    //  外勤人员
    private int outerId;
    // 会计
    private int  accountantId;
    // 入库日期
    private String createDate;
    // 入库数量
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getOuterId() {
        return outerId;
    }

    public void setOuterId(int outerId) {
        this.outerId = outerId;
    }

    public int getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(int accountantId) {
        this.accountantId = accountantId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
