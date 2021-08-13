package com.citi.training.PersonalPortfolioManager.repo;

import com.citi.training.PersonalPortfolioManager.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HoldingRepository extends JpaRepository<Holding, Integer> {
    Collection<Holding> findById(int id);
    Collection<Holding> findByAccountId(int accountId);
    Collection<Holding> findByAccountTicker(String ticker);
    Collection<Holding> findByAccountQuantity(double quantity);
}
