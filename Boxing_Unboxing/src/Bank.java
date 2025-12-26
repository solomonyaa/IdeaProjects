import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            this.customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addTransaction(String from, String to, double amount) {

        if (getIndex(from) >= 0 && getIndex(to) >= 0) {
            if(amount <= customers.get(getIndex(from)).getBalance()){
                customers.get(getIndex(from)).withdraw(amount);
                customers.get(getIndex(to)).deposit(amount);
                customers.get(getIndex(from)).addTransaction(amount * (-1));
                customers.get(getIndex(to)).addTransaction(amount);
                return true;
            }
            else{
                System.out.println("Transaction was not executed due to lack of funds in " + customers.get(getIndex(from)).getName() + "'s account.");
            }
        }
        return false;
    }

    private Customer findCustomer(String name) {

        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    private int getIndex(String name) {
        if (findCustomer(name) != null) {
            return customers.indexOf(findCustomer(name));
        }
        return -1;
    }

    public void printInfo() {
        for (Customer c : customers) {
            var transactions = c.getTransactions();

            System.out.println(c.getName() + " has " + c.getTransactions().size() + " transaction(s): ");
            for(double d : c.getTransactions()){ // auto unboxing
                System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
            }
        }
    }
}
