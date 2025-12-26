package dev.lpa;

import dev.bank.Bank;
import dev.bank.BankAccount;
import dev.bank.BankAccount.AccountType;
import dev.bank.BankCustomer;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500.00, 10000.00);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        var transactionSuccess = bank.doTransaction(joe.getCustomerId(),
                AccountType.CHECKING, 35);
        if (transactionSuccess)
            System.out.println(joe);

        transactionSuccess = bank.doTransaction(joe.getCustomerId(),
                AccountType.CHECKING, -535);

        if (transactionSuccess)
            System.out.println(joe);

        System.out.println("-".repeat(100));

        BankAccount checking = joe.getAccount(AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

        joe.getAccount(AccountType.CHECKING).getTransactions().clear();
        System.out.println("-".repeat(100));

        joe.getAccount(AccountType.CHECKING).getTransactions()
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
