package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import com.citi.training.PersonalPortfolioManager.repo.InvestmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class InvestmentTransactionServiceImpl implements InvestmentTransactionService {

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    @Override
    public InvestmentTransaction getTransactionById(int id) {return investmentTransactionRepository.findById(id);}

    @Override
    public Collection<InvestmentTransaction> getTransactionsByAccountId(int accountId) {return investmentTransactionRepository.findByAccountId(accountId);}

    @Override
    public Collection<InvestmentTransaction> getTransactionByTicker(String ticker) {return investmentTransactionRepository.findByTicker(ticker);}

    @Override
    public Collection<InvestmentTransaction> getTransactionByQuantity(double quantity) {return  investmentTransactionRepository.findByQuantity(quantity);}

    @Override
    public Collection<InvestmentTransaction> getTransactionByDate(Date date) {return investmentTransactionRepository.findByDate(date);}

}
