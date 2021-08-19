package com.citi.training.rest;

import com.citi.training.entity.Holding;
import com.citi.training.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Holding getHoldingById(@PathVariable("id") int id) {
        return holdingService.getHoldingById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    public Collection<Holding> getHoldingsByAccountId(@PathVariable("accountId") int accountId) {
        return holdingService.getHoldingsByAccountId(accountId);
    }
}
