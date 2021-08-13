package com.citi.training.PersonalPortfolioManager.repo;

import com.citi.training.PersonalPortfolioManager.entity.InvestmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface InvestmentTransactionRepository extends JpaRepository<InvestmentTransaction, Integer> {
    Collection<InvestmentTransaction> findById(int id);
    Collection<InvestmentTransaction> findByAccountId(int accountId);
    Collection<InvestmentTransaction> findByTicker(String ticker);
    Collection<InvestmentTransaction> findByPricePer(double pricePer);
    Collection<InvestmentTransaction> findByQuantity(double quantity);
    Collection<InvestmentTransaction> findByDate(Date date);
}
