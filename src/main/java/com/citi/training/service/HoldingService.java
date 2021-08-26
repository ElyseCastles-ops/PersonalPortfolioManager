package com.citi.training.service;

import com.citi.training.entity.Gainer;
import com.citi.training.entity.Holding;
import com.citi.training.entity.Mover;

import java.util.Collection;
import java.util.LinkedHashMap;

public interface HoldingService {
    Holding getHoldingById(int id);

    Collection<Holding> getHoldingsByAccountId(int accountId);

    Collection<Holding> getHoldingByAccountTicker(String ticker);

    Collection<Holding> getHoldingByAccountQuantity(double quantity);

    Collection<Holding> getAllHoldings();

    Holding getHoldingByTickerAndAccountId(String ticker, Integer accountId);

    Collection<Gainer> getGainersLosers();

    Collection<Mover> getMarketMovers();
}
