package com.bank.loanservice.controller;

import com.bank.loanservice.model.Customer;
import com.bank.loanservice.model.Loan;
import com.bank.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanRepository loanRepository;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody Customer customer){
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());

        if(loans != null){
            return loans;
        } else {
            return null;
        }
    }
}
