package com.citi.training.PersonalPortfolioManager.repo;

import com.citi.training.PersonalPortfolioManager.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(int id);
    Collection<Account> findByName(String name);
    Collection<Account> findByType(String type);
    Collection<Account> findByDescription(String description);
    Collection<Account> findByBalance(double balance);
}
