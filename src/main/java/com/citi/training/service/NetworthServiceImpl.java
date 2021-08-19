package com.citi.training.service;

import com.citi.training.entity.Networth;
import com.citi.training.repo.NetworthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class NetworthServiceImpl implements NetworthService {
    @Autowired
    private NetworthRepository networthRepository;

    @Override
    public Networth getNetworthInfoByDate(LocalDate date) {
        return networthRepository.findByDate(date);
    }

    @Override
    public Collection<Networth> getAllNetworthInfo() {
        return networthRepository.findAll();
    }

    @Override
    public double getNetworthAmountByDate(LocalDate date) {
        return networthRepository.findByDate(date).getNetworth();
    }

    @Override
    public double getTotalCashByDate(LocalDate date) {
        return networthRepository.findByDate(date).getTotalCash();
    }

    @Override
    public double getTotalInvestmentByDate(LocalDate date) {
        return networthRepository.findByDate(date).getTotalInvestment();
    }

    @Override
    public Networth getCurrentNetworthInfo() {
        LocalDate myDate = LocalDate.now();
        return networthRepository.findByDate(myDate);
    }

    @Override
    public double getCurrentNetworth() {
        LocalDate myDate = LocalDate.now();
        return networthRepository.findByDate(myDate).getNetworth();
    }

    @Override
    public double getCurrentTotalCash() {
        LocalDate myDate = LocalDate.now();
        return networthRepository.findByDate(myDate).getTotalCash();
    }

    @Override
    public double getCurrentTotalInvestment() {
        LocalDate myDate = LocalDate.now();
        return networthRepository.findByDate(myDate).getTotalInvestment();
    }
}
