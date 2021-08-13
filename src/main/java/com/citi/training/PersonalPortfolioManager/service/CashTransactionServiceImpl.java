package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class CashTransactionServiceImpl implements CashTransactionService {

    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    @Override
    public Collection<CashTransaction> getTransactionById(int id) {return cashTransactionRepository.findById(id);}

    @Override
    public Collection<CashTransaction> getTransactionByAccountId(int accountId) {return cashTransactionRepository.findByAccountId(accountId);}

    @Override
    public Collection<CashTransaction> getTransactionByName(String name) {return cashTransactionRepository.findByName(name);}

    @Override
    public Collection<CashTransaction> getTransactionByAmount(double amount) {return  cashTransactionRepository.findByAmount(amount);}

    @Override
    public Collection<CashTransaction> getTransactionByDate(Date date) {return cashTransactionRepository.findByDate(date);}
}
