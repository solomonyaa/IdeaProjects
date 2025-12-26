package dev.Bank;


public class BankAccount {

    public enum Type {
        CHECKING,
        SAVINGS,
        NORMAL
    }

    private final Type type;
    private final double balance;

    public BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

/*    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount){
        this.balance += amount;
    }*/

    public Type getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance(){
        System.out.println("balance = " + balance);
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(type, balance);
    }
}
