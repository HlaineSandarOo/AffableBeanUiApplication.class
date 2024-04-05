package com.example.paymentgateway.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String accountNumber;
    private double amount;

    @PrePersist
    public void prePersists(){
        amount = 0.00;
    }
}
