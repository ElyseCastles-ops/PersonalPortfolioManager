package com.citi.training.repo;

import com.citi.training.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface HoldingRepository extends JpaRepository<Holding, Integer> {
    Holding findById(int id);
    Collection<Holding> findByAccountId(int accountId);
    Collection<Holding> findByTicker(String ticker);
    Holding findByTickerAndAccountId(String ticker, Integer accountId);
    Collection<Holding> findByQuantity(double quantity);
    List<Holding> findAll();
}
