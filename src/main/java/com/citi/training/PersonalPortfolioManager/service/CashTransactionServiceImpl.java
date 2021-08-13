package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import com.citi.training.PersonalPortfolioManager.repo.CashTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class CashTransactionServiceImpl implements CashTransactionService {

    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    @Override
    public CashTransaction getTransactionById(int id) {return cashTransactionRepository.findById(id);}

    @Override
    public Collection<CashTransaction> getTransactionsByAccountId(int accountId) {return cashTransactionRepository.findByAccountId(accountId);}

    @Override
    public Collection<CashTransaction> getTransactionByName(String name) {return cashTransactionRepository.findByName(name);}

    @Override
    public Collection<CashTransaction> getTransactionByAmount(double amount) {return  cashTransactionRepository.findByAmount(amount);}

    @Override
    public Collection<CashTransaction> getTransactionByDate(Date date) {return cashTransactionRepository.findByDate(date);}

    @Override
    public CashTransaction addCashTransaction(CashTransaction transaction) {
        return cashTransactionRepository.save(transaction);
    }
}
