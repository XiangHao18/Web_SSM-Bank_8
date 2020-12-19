package com.ssm.pojo;

import com.ssm.controller.validation.ValidGroupByBankcard;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Bankcard {

//    @Size(min = 19,max = 19,message = "bankcard.card.length.error",groups = ValidGroupByBankcard.class)
    private String cardId;

    private Integer custId;

    private Date createDate;

    private Double createMoney;

    private String currencyType;

    private String depositType;

    private Double balance;

    @NotNull(message = "bankcard.password.length.error",groups = ValidGroupByBankcard.class)
    private String password;

    private Integer reportLoss;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getCreateMoney() {
        return createMoney;
    }

    public void setCreateMoney(Double createMoney) {
        this.createMoney = createMoney;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType == null ? null : depositType.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getReportLoss() {
        return reportLoss;
    }

    public void setReportLoss(Integer reportLoss) {
        this.reportLoss = reportLoss;
    }
}