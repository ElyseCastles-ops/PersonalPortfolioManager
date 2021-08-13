package com.citi.training.PersonalPortfolioManager.rest;

import com.citi.training.PersonalPortfolioManager.entity.Account;
import com.citi.training.PersonalPortfolioManager.repo.AccountRepository;
import com.citi.training.PersonalPortfolioManager.service.AccountService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

   /* @GetMapping
    public Collection<Account> getAccounts() {
        return accountService.getAllAccounts();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getById(id);
    }

}
