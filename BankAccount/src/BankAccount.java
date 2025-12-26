public class BankAccount
{
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount()
    {
        this(10001, 0.0, "default name",
                "default email", "default phone");
    }
    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public int getAccountNumber()
    {
        return this.accountNumber;
    }
    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double sumToDeposit)
    {
        this.balance += sumToDeposit;
    }
    public void withdraw(double sumToWithdraw)
    {
        if(this.balance - sumToWithdraw < 0)
            return;
        else
            this.balance -= sumToWithdraw;
    }
    @Override
    public String toString()
    {
        return "Account number: " + this.accountNumber +
                "\nCustomer name: " + this.customerName +
                "\nBalance: $" + this.balance +
                "\nEmail: " + this.email +
                "\nPhone Number: " + this.phoneNumber;
    }
}


