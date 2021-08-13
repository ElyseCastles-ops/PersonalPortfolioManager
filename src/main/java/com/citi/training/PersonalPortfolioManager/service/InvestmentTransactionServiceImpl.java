package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class InvestmentTransactionServiceImpl implements InvestmentTransactionService {

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    @Override
    public Collection<CashTransaction> getTransactionById(int id) {return investmentTransactionRepository.findById(id);}

    @Override
    public Collection<CashTransaction> getTransactionByAccountId(int accountId) {return investmentTransactionRepository.findByAccountId(accountId);}

    @Override
    public Collection<CashTransaction> getTransactionByName(String name) {return investmentTransactionRepository.findByName(name);}

    @Override
    public Collection<CashTransaction> getTransactionByAmount(double amount) {return  investmentTransactionRepository.findByAmount(amount);}

    @Override
    public Collection<CashTransaction> getTransactionByDate(Date date) {return investmentTransactionRepository.findByDate(date);}

}
