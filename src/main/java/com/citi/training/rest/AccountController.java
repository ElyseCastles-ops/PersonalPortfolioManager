package com.citi.training.rest;

import com.citi.training.entity.Account;
import com.citi.training.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

   /* @GetMapping
    public Collection<Account> getAccounts() {
        return accountService.getAllAccounts();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/cash")
    public Collection<Account> getCashAccounts() {
        return accountService.getByType("Cash");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/balance/{id}")
    public double getAccountBalance(@PathVariable("id") int id) {
        return accountService.getAccountBalance(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/cash/total")
    public double getCashAccountsTotal() {
        return accountService.getTotalValueOfAllCashAccounts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment/total")
    public double getInvestmentAccountsTotal() {
        return accountService.getAllInvestmentAccountsTotalValue();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment/total/{id}")
    public double getInvestmentAccountTotalById(@PathVariable("id") int id) {
        return accountService.getInvestmentAccountTotalValueById(id);
    }

    @RequestMapping("/networth")
    public double getNetWorth() {
        return accountService.getNetWorth();
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Account> findAll() { return accountService.getAllAccounts();}

}
