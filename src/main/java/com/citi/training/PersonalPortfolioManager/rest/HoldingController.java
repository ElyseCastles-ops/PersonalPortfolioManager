package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.Holding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/holdings")
public class HoldingController {
    @Autowired
    private HoldingService holdingService;

    @GetMapping
    public Collection<Holding> getHoldings() {
        return holdingService.getAllHoldings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Holding getHoldingById() {
        return holdingService.getHoldingById();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<Holding> getHoldingsByAccountId() {
        return holdingService.getHoldingsByAccountId();
    }
}
