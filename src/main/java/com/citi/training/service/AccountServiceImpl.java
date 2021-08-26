package com.citi.training.service;


import com.citi.training.entity.Account;
import com.citi.training.entity.Holding;
import com.citi.training.model.StockWrapper;
import com.citi.training.repo.AccountRepository;
import com.citi.training.repo.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Collection;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HoldingRepository holdingRepository;

    @Autowired
    private StockService stockService;

    @Autowired
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public Account getById(int id) { return accountRepository.findById(id);}

    public Collection<Account> getByName(String name) { return accountRepository.findByName(name);}

    public Collection<Account> getByType(String type) { return accountRepository.findByType(type);}

    public Collection<Account> getByDescription(String des) { return accountRepository.findByDescription(des);}

    public Collection<Account> getByBalance(Double balance) { return accountRepository.findByBalance(balance);}

    @Override
    public double getInvestmentAccountTotalValue(Account account) {
        Double accountTotal = 0.0;
        Collection<Holding> accountHoldings = holdingRepository.findByAccountId(account.getId());
        for (Holding holding : accountHoldings) {
            try {
                StockWrapper stock = stockService.findStock(holding.getTicker());
                accountTotal = accountTotal + (stock.getStock().getQuote().getPrice().doubleValue() * holding.getQuantity());
            }
            catch (NullPointerException e) {
                System.out.println("No stock price found for " + holding.getTicker());
            }
        }
        account.setBalance(accountTotal);
        accountRepository.save(account);
        return accountTotal;
    }

    @Override
    public double getInvestmentAccountTotalValueById(Integer id) {
        Double accountTotal = 0.0;
        Collection<Holding> accountHoldings = holdingRepository.findByAccountId(id);
        for (Holding holding : accountHoldings) {
            try {
                StockWrapper stock = stockService.findStock(holding.getTicker());
                accountTotal = accountTotal + (stock.getStock().getQuote().getPrice().doubleValue() * holding.getQuantity());
            }
            catch (NullPointerException e) {
                System.out.println("No stock price found for " + holding.getTicker());
            }
        }
        return Double.parseDouble(df2.format(accountTotal));
    }

    public double getAccountBalance(int id) {
        return accountRepository.findById(id).getBalance();
    }

    public double getTotalValueOfAllCashAccounts() {
        Collection<Account> cashAccounts = accountRepository.findByType("Cash");
        Double sum = 0.0;
        for (Account account : cashAccounts) {
            sum = sum + account.getBalance();
        }
        return sum;
    }


    public double getAllInvestmentAccountsTotalValue() {
        Collection<Account> investmentAccounts = accountRepository.findByType("Investment");
        Double sum = 0.0;
        Double accountSum = 0.0;
        for (Account account : investmentAccounts) {
            accountSum = getInvestmentAccountTotalValue(account);
            sum = sum + accountSum;
        }
        return sum;
    }

    public double getNetWorth() {
        Double sum = getTotalValueOfAllCashAccounts();
        sum = sum + getAllInvestmentAccountsTotalValue();
        return sum;
    }

    @Override
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
