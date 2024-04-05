package com.example.paymentgateway.controller;

import com.example.paymentgateway.dto.AccountDto;
import com.example.paymentgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }
    @PostMapping("/deposit")
    public ResponseEntity<Double> depositAmount(@RequestParam("accountNumber")
                                                String accountNumber,
                                                @RequestParam("amount")
                                                double amount) {
        return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
    }
    @PostMapping("/transaction")
    public ResponseEntity<String> makeTransaction(@RequestParam("ownerAccountNumber") String ownerAccountNumber,
                                              @RequestParam("customerAccountNumber") String customerAccountNumber,
                                              @RequestParam("amount") double amount) {
        accountService.makeTransaction(ownerAccountNumber, customerAccountNumber, amount);
        return ResponseEntity.ok("Successful Transaction!");
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Double> withdrawAmount(@RequestParam ("accountNumber") String accountNumber,
                                                 @RequestParam("amount") double amount) {
        return ResponseEntity.ok(accountService.withdraw(accountNumber,amount));
    }
}
