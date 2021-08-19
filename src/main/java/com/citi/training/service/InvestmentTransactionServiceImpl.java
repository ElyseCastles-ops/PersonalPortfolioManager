package com.citi.training.service;

import com.citi.training.entity.Holding;
import com.citi.training.entity.InvestmentTransaction;
import com.citi.training.repo.HoldingRepository;
import com.citi.training.repo.InvestmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;

@Service
public class InvestmentTransactionServiceImpl implements InvestmentTransactionService {

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    @Autowired
    private HoldingRepository holdingRepository;

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

    @Override
    public Collection<InvestmentTransaction> getAllInvestmentTransactions() {
        return investmentTransactionRepository.findAll();
    }

    @Override
    public InvestmentTransaction addInvestmentTransaction(InvestmentTransaction transaction) {
        try {
            Holding h = holdingRepository.findByTickerAndAccountId(transaction.getTicker(), transaction.getAccountId());
            h.setQuantity(h.getQuantity()+transaction.getQuantity());
            Holding newHolding = holdingRepository.save(h);
        }
        catch (NullPointerException e){
            holdingRepository.save(new Holding(transaction.getAccountId(), transaction.getTicker(), transaction.getQuantity())); // add new values
        }
        return investmentTransactionRepository.save(transaction);
    }


}
