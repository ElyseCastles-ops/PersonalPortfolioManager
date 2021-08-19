package com.citi.training.service;

import com.citi.training.entity.Account;

import java.util.Collection;

public interface AccountService {

    Account getById(int id);

    Collection<Account> getByName(String name);

    Collection<Account> getByType(String type);

    Collection<Account> getByDescription(String des);

    Collection<Account> getByBalance(Double balance);

}
