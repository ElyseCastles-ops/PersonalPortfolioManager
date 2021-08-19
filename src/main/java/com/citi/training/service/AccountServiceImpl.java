package com.citi.training.service;


import com.citi.training.entity.Account;
import com.citi.training.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getById(int id) { return accountRepository.findById(id);}

    public Collection<Account> getByName(String name) { return accountRepository.findByName(name);}

    public Collection<Account> getByType(String type) { return accountRepository.findByType(type);}

    public Collection<Account> getByDescription(String des) { return accountRepository.findByDescription(des);}

    public Collection<Account> getByBalance(Double balance) { return accountRepository.findByBalance(balance);}

    public double getAccountBalance(int id) {
        return accountRepository.findById(id).getBalance();
    }

    public double getAllCashAccountValue() {
        Collection<Account> cashAccounts = accountRepository.findByType("Cash");
        Double sum = 0.0;
        for (Account account : cashAccounts) {
            sum = sum + account.getBalance();
        }
        return sum;
    }

    public double getAllInvestmentAccountValue() {
        Collection<Account> investmentAccounts = accountRepository.findByType("Investment");
        Double sum = 0.0;
        for (Account account : investmentAccounts) {
            //TODO: get live price and update balance for investment accounts
            sum = sum + account.getBalance();
        }
        return sum;
    }

    public double getNetWorth() {
        Double sum = getAllCashAccountValue();
        sum = sum + getAllInvestmentAccountValue();
        return sum;
    }

    @Override
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}