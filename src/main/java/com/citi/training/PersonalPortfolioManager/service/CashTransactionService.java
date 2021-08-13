package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;

import java.util.Collection;
import java.util.Date;

public interface CashTransactionService {
    CashTransaction getTransactionById(int id);

    Collection<CashTransaction> getTransactionsByAccountId(int accountId);

    Collection<CashTransaction> getTransactionByName(String name);

    Collection<CashTransaction> getTransactionByAmount(double amount);

    Collection<CashTransaction> getTransactionByDate(Date date);

    CashTransaction addCashTransaction(CashTransaction transaction);
}
