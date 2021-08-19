package com.citi.training.service;

import com.citi.training.entity.InvestmentTransaction;

import java.util.Collection;
import java.util.Date;

public interface InvestmentTransactionService {
    InvestmentTransaction getTransactionById(int id);

    Collection<InvestmentTransaction> getTransactionsByAccountId(int accountId);

    Collection<InvestmentTransaction> getTransactionByTicker(String ticker);

    Collection<InvestmentTransaction> getTransactionByQuantity(double quantity);

    Collection<InvestmentTransaction> getTransactionByDate(Date date);
}
