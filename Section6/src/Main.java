public class Main {
    public static void main(String[] args) {
        Passat pasaciukas = new Passat(210, 250, 2006, "Diesel", 6.2,5,2.0, 2500, true);

        pasaciukas.move(50, 20);
        pasaciukas.move(-20, 10);

//        BankAccount johnsAccount = new BankAccount("1234", 0.00, "John Doe",
//                "john.doe@gmail.com", "+37000000000");
//
//        BankAccount bobsAccount = new BankAccount();
//        bobsAccount.withdrawFunds(100);
//        bobsAccount.depositFunds(150);
//        bobsAccount.withdrawFunds(100);
    }
}
