package com.citi.training.entity;

public class Gainer implements Comparable<Gainer> {

    private Integer accountId;
    private String ticker;
    private Double quantity;
    private Double percentChange;

    public Gainer() {
    }

    public Gainer(Integer accountId, String ticker, Double quantity, Double percentChange) {
        this.accountId = accountId;
        this.ticker = ticker;
        this.quantity = quantity;
        this.percentChange = percentChange;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    @Override
    public int compareTo(Gainer o) {
        if (this.getPercentChange() < o.getPercentChange()){
            return 1;
        }
        else if (this.getPercentChange().equals(o.getPercentChange()) ) {
            return 0;
        }
        else {
            return -1;
        }

    }
}

