package com.citi.training.service;


import com.citi.training.entity.Account;
import com.citi.training.entity.CashTransaction;
import com.citi.training.repo.AccountRepository;
import com.citi.training.repo.CashTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class CashTransactionServiceImpl implements CashTransactionService {

    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CashTransaction getTransactionById(int id) {return cashTransactionRepository.findById(id);}

    @Override
    public Collection<CashTransaction> getTransactionsByAccountId(int accountId) {return cashTransactionRepository.findByAccountId(accountId);}

    @Override
    public Collection<CashTransaction> getTransactionByName(String name) {return cashTransactionRepository.findByName(name);}

    @Override
    public Collection<CashTransaction> getTransactionByAmount(double amount) {return  cashTransactionRepository.findByAmount(amount);}

    @Override
    public Collection<CashTransaction> getTransactionByDate(Date date) {return cashTransactionRepository.findByDate(date);}

    @Override
    public CashTransaction addCashTransaction(CashTransaction transaction) {
        int account_id = transaction.getAccountId();
        Account a = accountRepository.findById(account_id);
        /*Should check for cash vs investment account IN THEORY*/
        a.setBalance(a.getBalance()+transaction.getAmount());
        accountRepository.save(a);
        return cashTransactionRepository.save(transaction);
    }

    /*public Account getAccountByAccountId(int id){
        return cashTransactionRepository.findAccountByAccountId(id);
    }*/

}
