package com.citi.training.rest;

import com.citi.training.entity.CashTransaction;
import com.citi.training.service.CashTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public CashTransaction addNewCashTransaction(@RequestBody CashTransaction transaction) {
        return cashTransactionService.addCashTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public CashTransaction getTransactionById(@PathVariable("id") int id) {
        return cashTransactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountid/{accountId}")
    public Collection<CashTransaction> getTransactionsByAccountId(@PathVariable("accountId") int accountId) {
        return cashTransactionService.getTransactionsByAccountId(accountId);
    }
}
