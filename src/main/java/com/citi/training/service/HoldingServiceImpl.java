package com.citi.training.service;

import com.citi.training.entity.Holding;
import com.citi.training.repo.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    private HoldingRepository holdingRepository;

    @Override
    public Holding getHoldingById(int id) {return holdingRepository.findById(id);}

    @Override
    public Collection<Holding> getHoldingsByAccountId(int accountId) {return  holdingRepository.findByAccountId(accountId);}

    @Override
    public Collection<Holding> getHoldingByAccountTicker(String ticker) {return holdingRepository.findByTicker(ticker);}

    @Override
    public Collection<Holding> getHoldingByAccountQuantity(double quantity){return holdingRepository.findByQuantity(quantity);}

    @Override
    public Collection<Holding> getAllHoldings() {
        return holdingRepository.findAll();
    }

    @Override
    public Holding getHoldingByTickerAndAccountId(String ticker, Integer accountId) {
        return holdingRepository.findByTickerAndAccountId(ticker, accountId);
    }


}
