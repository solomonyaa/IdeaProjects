import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;
    private double balance;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public Customer(String name, double balance) {
        this(name);
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " | Balance: " + this.balance;
    }
}
