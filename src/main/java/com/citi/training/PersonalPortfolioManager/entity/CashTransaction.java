package com.citi.training.PersonalPortfolioManager.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cashtransactions")
public class CashTransaction implements Transaction{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="account_id")
    private Integer accoutId;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private Double amount;

    @Column(name="date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(int accoutId) {
        this.accoutId = accoutId;
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
