package com.citi.training.service;

import com.citi.training.entity.Account;

import java.util.Collection;

public interface AccountService {

    Account getById(int id);

    Collection<Account> getByName(String name);

    Collection<Account> getByType(String type);

    Collection<Account> getByDescription(String des);

    Collection<Account> getByBalance(Double balance);

    public double getInvestmentAccountTotalValue(Account account);

    public double getInvestmentAccountTotalValueById(Integer id); //To be removed later

    public double getAllInvestmentAccountsTotalValue();

    public double getTotalValueOfAllCashAccounts();

    double getAccountBalance(int id);

    double getNetWorth();

    Iterable<Account> getAllAccounts();

}
