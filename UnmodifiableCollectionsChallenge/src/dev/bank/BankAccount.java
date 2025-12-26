package dev.bank;

import dev.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {

    private final AccountType accountType;
    private final Map<Long, Transaction> transactions;
    private double balance;

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = new LinkedHashMap<>(); // a sorted map
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public double getBalance() {
        return this.balance;
    }

    public Map<Long, String> getTransactions() {
        // returning a modifiable collection with immutable data
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    // access modifier = package-private
    void commitTransaction(int routingNumber, long transactionId,
                           String customerId, double amount) {
        // validation for balance is done outside of this class (dev.bank.Bank)
        balance += amount;
        transactions.put(transactionId,
                new Transaction(routingNumber, transactionId,
                        Integer.parseInt(customerId), amount));
    }

    public String toString() {
        return "%s $%.2f".formatted(this.accountType, this.balance);
    }

    public enum AccountType {CHECKING, SAVINGS}
}
