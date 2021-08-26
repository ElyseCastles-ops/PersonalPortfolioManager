package com.citi.training.rest;

import com.citi.training.entity.Account;
import com.citi.training.entity.Networth;
import com.citi.training.service.NetworthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/networth")
public class NetworthController {
    @Autowired
    private NetworthService networthService;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Networth> findAll() { return networthService.getAllNetworthInfo();}

    @RequestMapping(method = RequestMethod.GET, value = "/{date}")
    Networth getNetworthInfoByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return networthService.getNetworthInfoByDate(date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/amount/{date}")
    double getNetworthAmountByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return networthService.getNetworthAmountByDate(date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cash/{date}")
    double getTotalCashByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return networthService.getTotalCashByDate(date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment/{date}")
    double getTotalInvestmentByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return networthService.getTotalInvestmentByDate(date);
    }
    @RequestMapping("/currentinfo")
    Networth getCurrentNetworthInfo() {return networthService.getCurrentNetworthInfo();}

    @RequestMapping("/currentamount")
    double getCurrentNetworth() {return networthService.getCurrentNetworth();}

    @RequestMapping("/currentcash")
    double getCurrentTotalCash() {return networthService.getCurrentTotalCash();}

    @RequestMapping("/currentinvestment")
    double getCurrentTotalInvestment() {return networthService.getCurrentTotalInvestment();}


}
