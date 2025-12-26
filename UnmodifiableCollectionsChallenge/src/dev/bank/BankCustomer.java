package dev.bank;

import dev.bank.BankAccount.AccountType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int lastCustomerId = 10_000_000;
    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

    //package private
    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        this.accounts.add(new BankAccount(AccountType.CHECKING, checkingAmount));
        this.accounts.add(new BankAccount(AccountType.SAVINGS, savingsAmount));
    }

    public String getName() {
        return this.name;
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    public BankAccount getAccount(AccountType type){

        for (BankAccount ba : accounts){
            if(ba.getAccountType() == type)
                return ba;
        }
        return null;
    }

    public String toString() {

        String[] accountStrings = new String[this.accounts.size()];
        Arrays.setAll(accountStrings, (i) -> this.accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(this.name, this.customerId, String.join("\n\t", accountStrings));
    }
}
