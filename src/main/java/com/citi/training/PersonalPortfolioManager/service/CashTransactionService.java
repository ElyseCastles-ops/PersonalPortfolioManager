package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;

import java.util.Collection;
import java.util.Date;

public interface CashTransactionService {
    Collection<CashTransaction> getTransactionById(int id);

    Collection<CashTransaction> getTransactionByAccountId(int accountId);

    Collection<CashTransaction> getTransactionByName(String name);

    Collection<CashTransaction> getTransactionByAmount(double amount);

    Collection<CashTransaction> getTransactionByDate(Date date);
}
