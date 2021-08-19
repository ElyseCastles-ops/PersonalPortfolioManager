package com.citi.training.rest;

import com.citi.training.entity.InvestmentTransaction;
import com.citi.training.service.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public InvestmentTransaction getTransactionById(@PathVariable("id") int id) {
        return investmentTransactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountid/{accountId}")
    public Collection<InvestmentTransaction> getTransactionsByAccountId(@PathVariable("accountId") int accountId) {
        return investmentTransactionService.getTransactionsByAccountId(accountId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public InvestmentTransaction addNewInvestmentTransaction(@RequestBody InvestmentTransaction transaction) {
        return investmentTransactionService.addInvestmentTransaction(transaction);
    }

}
