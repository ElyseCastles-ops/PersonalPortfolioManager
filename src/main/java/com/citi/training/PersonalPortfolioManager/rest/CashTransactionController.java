package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.Account;
import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cashtransactions")
public class CashTransactionController {

    @Autowired
    private CashTransactionService cashTransactionService;

    @GetMapping
    public Collection<CashTransaction> getCashTransactions() {
        return cashTransactionService.getAllCashTransactions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CashTransaction getTransactionById() {
        return cashTransactionService.getTransactionById();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<CashTransaction> getTransactionsByAccountId() {
        return cashTransactionService.getTransactionsByAccountId();
    }
}
