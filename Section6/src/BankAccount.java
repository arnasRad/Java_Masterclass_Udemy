public class BankAccount {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String phoneNumber;

    public BankAccount() {
        this("56789", 0.00, "Default name", "Default address", "Default phone");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String customerName, String customerEmail, String phoneNumber) {
        this("56789", 0.00, customerName, customerEmail, phoneNumber);
    }

    public BankAccount(String number, double balance, String customerName,
                       String customerEmail, String phoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double funds) {
        this.balance += funds;
        System.out.println(funds + " added to bank account. New balance: " +
                this.balance);
    }

    public void withdrawFunds(double funds) {
        if (this.balance >= funds) {
            this.balance -= funds;
            System.out.println(funds + " withdrawn from bank account. New balance: " +
                    this.balance);
        } else {
            System.out.println("Insufficient funds. Remaining funds: " +
                    this.balance + ", tried to withdraw: " + funds);
        }
    }
}
