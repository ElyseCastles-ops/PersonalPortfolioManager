package com.citi.training.PersonalPortfolioManager.repo;

import com.citi.training.PersonalPortfolioManager.entity.CashTransaction;
import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.*;

public interface CashTransactionRepository extends JpaRepository<CashTransaction, Integer> {
    Collection<CashTransaction> findById(int id);
    Collection<CashTransaction> findByAccountId(int accountId);
    Collection<CashTransaction> findByName(String name);
    Collection<CashTransaction> findByAmount(double amount);
    Collection<CashTransaction> findByDate(Date date);
}
