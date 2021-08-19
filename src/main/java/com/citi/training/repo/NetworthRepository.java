package com.citi.training.repo;

import com.citi.training.entity.Networth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.time.LocalDate;

public interface NetworthRepository extends JpaRepository<Networth,Integer> {
    Networth findById(int id);
    Networth findByDate(LocalDate date);
}
