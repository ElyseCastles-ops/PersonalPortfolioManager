package com.citi.training.service;

import com.citi.training.entity.Holding;

import java.util.Collection;

public interface HoldingService {
    Holding getHoldingById(int id);

    Collection<Holding> getHoldingsByAccountId(int accountId);

    Collection<Holding> getHoldingByAccountTicker(String ticker);

    Collection<Holding> getHoldingByAccountQuantity(double quantity);

    Collection<Holding> getAllHoldings();

    Holding getHoldingByTickerAndAccountId(String ticker, Integer accountId);
}