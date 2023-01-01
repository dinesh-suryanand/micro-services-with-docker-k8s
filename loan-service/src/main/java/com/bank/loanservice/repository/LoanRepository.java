package com.bank.loanservice.repository;

import com.bank.loanservice.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Loan> {
    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
