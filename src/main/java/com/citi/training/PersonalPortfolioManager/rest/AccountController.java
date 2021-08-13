package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.Account;
import com.citi.training.PersonalPortfolioManager.repo.AccountRepository;
import com.citi.training.PersonalPortfolioManager.service.AccountService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/balance/{id}")
    public double getAccountBalance(@PathVariable("id") int id) {
        return accountService.getAccountBalance(id);

    }

    @RequestMapping("/networth")
    public double getNetWorth() {
        return accountService.getNetWorth();
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Account> findAll() { return accountService.getAllAccounts();}
}
