import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final Lock lock;
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
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
        boolean status = false;

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance += amount;
                    System.out.println(amount + " deposited. Current account balance: " + balance);
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Lock was not acquired in deposit() method");
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("Transaction status = " + status);

        /* challenge #4 */
//        lock.lock();
//        try {
//            balance += amount;
//            System.out.println(amount + " deposited. Current account balance: " + balance);
//        } finally {
//            lock.unlock();
//        }
    }

    public void withdraw(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance -= amount;
                    System.out.println(amount + " withdrawn. Current account balance: " + balance);
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Lock was not acquired in withdraw() method");
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("Transaction status = " + status);

//        lock.lock();
//        try {
//            balance -= amount;
//            System.out.println(amount + " withdrawn. Current account balance: " + balance);
//        } finally {
//            lock.unlock();
//        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printBankAccountNumber() {
        System.out.println("Account No.: " + this.accountNumber);
    }
}
