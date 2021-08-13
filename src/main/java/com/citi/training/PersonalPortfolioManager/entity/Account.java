package com.citi.training.PersonalPortfolioManager.entity;

import javax.persistence.*;

@Entity
@Table(name="accounts")
/*@NamedQueries({
        @NamedQuery(name="account.getAllCashAccounts",
                query="select a from Account as a where a.type like Cash",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})*/
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @Column(name="balance")
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
