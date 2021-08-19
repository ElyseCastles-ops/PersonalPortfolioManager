package com.citi.training.repo;

import com.citi.training.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HoldingRepository extends JpaRepository<Holding, Integer> {
    Holding findById(int id);
    Collection<Holding> findByAccountId(int accountId);
    Collection<Holding> findByTicker(String ticker);
    Collection<Holding> findByQuantity(double quantity);

}
