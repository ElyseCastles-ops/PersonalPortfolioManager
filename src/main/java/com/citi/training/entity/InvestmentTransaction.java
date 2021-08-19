package com.citi.training.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="investmenttransactions")
public class InvestmentTransaction implements Transaction{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="account_id")
    private Integer accountId;

    @Column(name="ticker")
    private String ticker;

    @Column(name="priceper")
    private Double priceper;

    @Column(name="quantity")
    private Double quantity;

    @Column(name="date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPriceper() {
        return priceper;
    }

    public void setPriceper(Double priceper) {
        this.priceper = priceper;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
