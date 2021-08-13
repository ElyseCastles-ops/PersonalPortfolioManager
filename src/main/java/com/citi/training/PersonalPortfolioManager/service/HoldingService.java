package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.Holding;

import java.util.Collection;

public interface HoldingService {
    Collection<Holding> getHoldingById(int id);

    Collection<Holding> getHoldingByAccountId(int accountId);

    Collection<Holding> getHoldingByAccountTicker(String ticker);

    Collection<Holding> getHoldingByAccountQuantity(double quantity);
}
