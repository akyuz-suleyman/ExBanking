package com.ExBanking.pojos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MoneyTransfer {

    private String fromAccountNumber;
    private String toAccountNumber;
    private double transferAmount;
    private String comment;

}
