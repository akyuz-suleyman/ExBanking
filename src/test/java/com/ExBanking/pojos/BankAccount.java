package com.ExBanking.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankAccount {

    private String accountNumber;
    private String currency;
    private double amount;


}
