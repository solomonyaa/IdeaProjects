package dev.Bank;

import java.util.List;

public class BankCustomer {

    private final String name;

    private final int id;

    private static int staticID = 10001;

    private final List<BankAccount> accounts;


    public BankCustomer(String name, List<BankAccount> accounts) {

        this.id = staticID++;
        this.name = name;
        this.accounts = accounts == null ? null : List.copyOf(accounts);
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", accounts=" + accounts +
               '}';
    }
}
