package com.citi.training.PersonalPortfolioManager.service;

import com.citi.training.PersonalPortfolioManager.entity.Account;

import java.util.Collection;

public interface AccountService {

    Collection<Account> getById(int id);

   Collection<Account> getByName(String name);

    Collection<Account> getByType(String type);

    Collection<Account> getByDescription(String des);

    Collection<Account> getByBalance(Double balance);

}
