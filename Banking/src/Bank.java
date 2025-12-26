import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {

        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {

        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        if (findBranch(branchName) != null) {

            System.out.println("Customer details for branch " + branchName);
            var b = findBranch(branchName);
            ArrayList<Customer> customers = b.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                System.out.println("Customer: " + c.getName() + "[" + (i + 1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = c.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        double d = c.getTransactions().get(j).doubleValue(); // manual unboxing
                        System.out.println(("[" + (j + 1) + "]" + " Amount " + d));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
