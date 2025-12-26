package dev.lpa;

import dev.Bank.BankAccount;
import dev.Bank.BankCustomer;
import dev.Bank.VIPCustomer;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankCustomer jimmy = new BankCustomer("Jimmy", List.of(
                new BankAccount(BankAccount.Type.NORMAL, 15000),
                new BankAccount(BankAccount.Type.SAVINGS, 50000)
        ));

        BankCustomer johnny = new BankCustomer("Johnny", List.of(
                new BankAccount(BankAccount.Type.CHECKING, 4000),
                new BankAccount(BankAccount.Type.NORMAL, 9000)
        ));

        System.out.println(jimmy);
        var accounts = jimmy.getAccounts();
        try {
            accounts.clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Error -> " + e);
        }
        System.out.println(jimmy);


        VIPCustomer jordan = new VIPCustomer("Jordan", List.of(
                new BankAccount(BankAccount.Type.NORMAL, 250000)
        ));


        try {
            jordan.getAccounts().add(new BankAccount(BankAccount.Type.SAVINGS, 500));
        } catch (UnsupportedOperationException e) {
            System.out.println("Error -> " + e);
        }

        try {
            johnny.getAccounts().remove(0);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error -> " + e);
        }


        System.out.println(jordan.getAccounts());
    }
}