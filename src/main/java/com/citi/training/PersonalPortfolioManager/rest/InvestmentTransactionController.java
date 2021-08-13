package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import com.citi.training.PersonalPortfolioManager.service.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/investmenttransactions")
public class InvestmentTransactionController {
    @Autowired
    private InvestmentTransactionService investmentTransactionService;

   /* @GetMapping
    public Collection<InvestmentTransaction> getInvestmentTransactions() {
        return investmentTransactionService.getAllInvestmentTransactions();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public InvestmentTransaction getTransactionById(@PathVariable("id") int id) {
        return investmentTransactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<InvestmentTransaction> getTransactionsByAccountId(@PathVariable("accountId") int accountId) {
        return investmentTransactionService.getTransactionsByAccountId(accountId);
    }

}
