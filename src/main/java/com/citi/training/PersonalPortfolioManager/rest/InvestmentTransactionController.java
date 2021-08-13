package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/investmenttransactions")
public class InvestmentTransactionController {
    @Autowired
    private InvestmentTransactionService investmentTransactionService;

    @GetMapping
    public Collection<InvestmentTransaction> getInvestmentTransactions() {
        return investmentTransactionService.getAllInvestmentTransactions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public InvestmentTransaction getTransactionById() {
        return investmentTransactionService.getTransactionById();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<InvestmentTransaction> getTransactionsByAccountId() {
        return investmentTransactionService.getTransactionsByAccountId();
    }

}
