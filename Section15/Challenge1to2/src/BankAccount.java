public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//        System.out.println(amount + " deposited. Current account balance: " + balance);
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//        System.out.println(amount + " withdrawn. Current account balance: " + balance);
//    }

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
        System.out.println(amount + " deposited. Current account balance: " + balance);
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
        }
        System.out.println(amount + " withdrawn. Current account balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printBankAccountNumber() {
        System.out.println("Account No.: " + this.accountNumber);
    }
}
