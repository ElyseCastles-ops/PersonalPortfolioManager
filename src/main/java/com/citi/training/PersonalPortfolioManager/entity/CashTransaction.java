package com.citi.training.PersonalPortfolioManager.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="cashtransactions")
public class CashTransaction implements Transaction, Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="account_id")
    private Integer accountId;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private Double amount;

    @Column(name="date")
    private Date date;

    public CashTransaction() {
    }

    public CashTransaction(Integer accountId, String name, Double amount, Date date) {
        this.accountId = accountId;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
