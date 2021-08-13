package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.Account;
import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import com.citi.training.PersonalPortfolioManager.service.CashTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cashtransactions")
public class CashTransactionController {

    @Autowired
    private CashTransactionService cashTransactionService;

    /*@GetMapping
    public Collection<CashTransaction> getCashTransactions() {
        return cashTransactionService.getAllCashTransactions();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CashTransaction getTransactionById(@PathVariable("id") int id) {
        return cashTransactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<CashTransaction> getTransactionsByAccountId(@PathVariable("accountId") int accountId) {
        return cashTransactionService.getTransactionsByAccountId(accountId);
    }
}
