package com.example.paymentgateway.dao;

import com.example.paymentgateway.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Integer> {
    @Query("""
select a.amount from Account a where a.accountNumber =?1
""")
    public double checkBalance(String accountNumber);

    public Optional<Account> findAccountByAccountNumber(String accountNumber);
}
