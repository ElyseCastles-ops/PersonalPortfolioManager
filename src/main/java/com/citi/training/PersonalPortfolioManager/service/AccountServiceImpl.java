package com.citi.training.PersonalPortfolioManager.service;


import com.citi.training.PersonalPortfolioManager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Collection<Account> getById(int id) { return accountRepository.findById(id);}

    public Collection<Account> getByName(String name) { return accountRepository.findByName(name);}

    public Collection<Account> getByType(String type) { return accountRepository.findByType(type);}

    public Collection<Account> getByDescription(String des) { return accountRepository.findByDescription(des);}

    public Collection<Account> getByBalance(Double balance) { return accountRepository.findByBalance(balance);}
}
