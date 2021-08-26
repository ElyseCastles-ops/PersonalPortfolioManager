package com.citi.training.model;

import yahoofinance.Stock;

import java.time.LocalDateTime;

public class StockWrapper implements Comparable<StockWrapper>{
    private final Stock stock;
    private final LocalDateTime lastAccessed;

    public StockWrapper(final Stock stock)
    {
        this.stock = stock;
        lastAccessed = LocalDateTime.now();
    }

    public Stock getStock() {
        return stock;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }


    @Override
    public int compareTo(StockWrapper o) {
        if (this.getStock().getQuote().getChangeInPercent().doubleValue() > o.getStock().getQuote().getChangeInPercent().doubleValue()) {
            return 1;
        }
        else if (this.getStock().getQuote().getChangeInPercent().doubleValue() == o.getStock().getQuote().getChangeInPercent().doubleValue()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
