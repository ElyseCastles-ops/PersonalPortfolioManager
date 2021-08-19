package com.citi.training.service;

import com.citi.training.entity.Networth;

import java.util.Collection;
import java.time.LocalDate;

public interface NetworthService {
    Networth getNetworthInfoByDate(LocalDate date);
    Collection<Networth> getAllNetworthInfo();
    double getNetworthAmountByDate(LocalDate date);
    double getTotalCashByDate(LocalDate date);
    double getTotalInvestmentByDate(LocalDate date);
    Networth getCurrentNetworthInfo();
    double getCurrentNetworth();
    double getCurrentTotalCash();
    double getCurrentTotalInvestment();

}
