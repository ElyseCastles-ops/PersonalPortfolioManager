package com.citi.training.repo;

import com.citi.training.entity.InvestmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface InvestmentTransactionRepository extends JpaRepository<InvestmentTransaction, Integer> {
    InvestmentTransaction findById(int id);
    Collection<InvestmentTransaction> findByAccountId(int accountId);
    Collection<InvestmentTransaction> findByTicker(String ticker);
    Collection<InvestmentTransaction> findByPriceper(double pricePer);
    Collection<InvestmentTransaction> findByQuantity(double quantity);
    Collection<InvestmentTransaction> findByDate(Date date);
    List<InvestmentTransaction> findAll();
}
