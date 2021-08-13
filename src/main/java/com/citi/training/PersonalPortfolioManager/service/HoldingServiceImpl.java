package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.Holding;
import com.citi.training.PersonalPortfolioManager.repo.HoldingRepository;
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
}
