package com.example.paymentgateway.service;

import com.example.paymentgateway.dao.AccountDao;
import com.example.paymentgateway.dto.AccountDto;
import com.example.paymentgateway.entity.Account;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService {
    public final AccountDao accountDao;

    @Transactional
    public void makeTransaction(String ownerAccountNumber,
                            String customerAccountNumber,
                            double amount) {
        withdraw(customerAccountNumber, amount);
        deposit(ownerAccountNumber, amount);
    }

    @Transactional
    public double withdraw(String accountNumber, double amount) {
        if (amount > checkBalance(accountNumber)) {
            throw new RuntimeException(amount + " Insufficient Amount!");
        }
        double updatedAmount = checkBalance(accountNumber) - amount;
        Account account = findAccountByAccountNumber(accountNumber);
        account.setAmount(updatedAmount);
        return updatedAmount;
    }
    public Account findAccountByAccountNumber(String accountNumber) {
        return accountDao.findAccountByAccountNumber(accountNumber)
                .orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public double deposit(String accountNumber, double amount) {
        Account account = findAccountByAccountNumber(accountNumber);
        account.setAmount(account.getAmount() + amount);
        return account.getAmount() ;
    }
    public double checkBalance(String accountNumber) {
        return accountDao.checkBalance(accountNumber);
    }
    public AccountDto createAccount(AccountDto accountDto) {
        return toDto(accountDao.save(toEntity(accountDto)));
    }
    public AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getAccountNumber(),
                account.getAmount()
        );

    }
    public Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setName(accountDto.getName());
        return account;
    }

    public String generateAccountNumber() {
        Random random = new Random();
        return "SHWE" + (random.nextInt(100000) + 100000);
    }
}
