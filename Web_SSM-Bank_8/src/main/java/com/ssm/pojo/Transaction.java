package com.ssm.pojo;

import java.util.Date;

public class Transaction {
    private Integer transanctionId;

    private String cardId;

    private Date transanctionDate;

    private String transanctionType;

    private Double transanctionPay;

    private String remarks;

    public Integer getTransanctionId() {
        return transanctionId;
    }

    public void setTransanctionId(Integer transanctionId) {
        this.transanctionId = transanctionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getTransanctionDate() {
        return transanctionDate;
    }

    public void setTransanctionDate(Date transanctionDate) {
        this.transanctionDate = transanctionDate;
    }

    public String getTransanctionType() {
        return transanctionType;
    }

    public void setTransanctionType(String transanctionType) {
        this.transanctionType = transanctionType == null ? null : transanctionType.trim();
    }

    public Double getTransanctionPay() {
        return transanctionPay;
    }

    public void setTransanctionPay(Double transanctionPay) {
        this.transanctionPay = transanctionPay;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}