package dev.bank;

import dev.bank.BankAccount.AccountType;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    public final int routingNumber;
    private final Map<String, BankCustomer> customers; // key = customer's ID
    private long lastTransactionId = 1;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        this.customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public void addCustomer(String name, double checkingInitialDeposit,
                            double savingsInitialDeposit) {

        var newCustomer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(newCustomer.getCustomerId(), newCustomer);
    }

    public boolean doTransaction(String customerId, AccountType type, double amount) {

        var customer = customers.get(customerId);
        if (customer != null) {
            var account = customer.getAccount(type);
            if (account != null) {
                if ((account.getBalance() + amount < 0)) {
                    System.out.println("Insufficient funds");
                } else {
                    account.commitTransaction(routingNumber, lastTransactionId++,
                            customerId, amount);
                    return true;
                }
            }
        } else {
            System.out.println("Invalid Customer ID");
        }

        return false;
    }
}
