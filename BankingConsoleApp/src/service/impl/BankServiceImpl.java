package service.impl;

import domain.Account;
import service.BankService;

import java.util.UUID;

public class BankServiceImpl implements BankService {

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();
        String accountNumber = UUID.randomUUID().toString(); // Change Later -> 10 + 1 = AC11

        Account a = new Account(accountNumber,accountType,0.0,customerId);


        return "";
    }
}
