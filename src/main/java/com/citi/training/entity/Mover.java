package com.citi.training.entity;

public class Mover {

    private String ticker;
    private String name;
    private Double percentChange;

    public Mover(String ticker, String name, Double percentChange) {
        this.ticker = ticker;
        this.name = name;
        this.percentChange = percentChange;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

}
