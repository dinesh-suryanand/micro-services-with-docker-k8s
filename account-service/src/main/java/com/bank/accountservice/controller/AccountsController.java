package com.bank.accountservice.controller;

import com.bank.accountservice.model.Accounts;
import com.bank.accountservice.model.Customer;
import com.bank.accountservice.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsRepository accountsRepository;

    @GetMapping("/accounts")
    public Accounts getAccountDetails(@RequestBody Customer customer){
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());

        if(accounts != null){
            return accounts;
        } else {
            return null;
        }
    }
}
