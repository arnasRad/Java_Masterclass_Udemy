public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0, "12345-678");

        Thread user1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });
        Thread user2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        });

        user1.start();
        user2.start();
    }
}
