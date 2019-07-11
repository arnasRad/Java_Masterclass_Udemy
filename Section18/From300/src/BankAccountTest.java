import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount bankAccount = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance = bankAccount.deposit(200.00, true);
        // delta parameter allows a specified value error (paklaida)
        assertEquals(1200.00, balance, 0);
//        assertEquals(1200.00, bankAccount.getBalance(), 0); // bad practice
    }

    @Test
    void withdraw() {
        fail("This test has yet to be implemented");
    }

    @Test
    void getBalance_deposit() {
        BankAccount bankAccount = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        bankAccount.deposit(200.00, true);
        // delta parameter allows a specified value error (paklaida)
        assertEquals(1200.00, bankAccount.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw() {
        BankAccount bankAccount = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        bankAccount.withdraw(200.00, true);
        // delta parameter allows a specified value error (paklaida)
        assertEquals(800, bankAccount.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        // PRINTS OUT ASSERT FAIL MESSAGE
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.SAVINGS);

        // better use assertTrue / assertFalse
//        assertEquals(true, account.isChecking());

        // messages let the developer know what changes needs to be made
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

//    @Test
//    public void dummyTest() {
//        assertEquals(20, 21);
//    }
}