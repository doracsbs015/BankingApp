package bank;

import com.package404.BankAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    private package404.BankAccount bankAccount;

    @Before
    public void initialize() {
        // Initialize the bank account before each test
        bankAccount = new package404.BankAccount("1", "dora");
    }

    @Test
    public void checkAccountNumber() {
        // Testing if the account holder name is correctly set
        bankAccount.setAccountHolderName("ddora");
        System.out.println(bankAccount.getAccountHolderName());
        assertEquals("ssai", bankAccount.getAccountHolderName());
    }

    @Test
    public void checkBankConstructor() {
        // Testing the constructor and initial values of the bank account
        assertEquals("1", bankAccount.getAccountNumber()); // Account number should be "1"
        assertEquals("sai", bankAccount.getAccountHolderName()); // Account holder name should be "sai"
        assertEquals(0.0, bankAccount.getBalance(), 0.0); // Balance should be 0.0 initially
    }

    @Test
    public void testDeposit() {
        // Testing deposit functionality
        bankAccount.deposit(10); // Deposit $10
        assertEquals(10.0, bankAccount.getBalance(), 0.0); // Balance should be 10.0 after deposit
    }

    @Test
    public void testDepositNegative() {
        // Testing deposit with a negative amount (should not change the balance)
        bankAccount.deposit(-10); // Attempt to deposit a negative amount
        assertEquals(0.0, bankAccount.getBalance(), 0.0); // Balance should remain 0.0 after invalid deposit
    }

    @Test
    public void testDepositZero() {
        // Testing deposit with zero (should not change the balance)
        bankAccount.deposit(0); // Attempt to deposit $0
        assertEquals(0.0, bankAccount.getBalance(), 0.0); // Balance should remain 0.0 after deposit
    }

    @Test
    public void testWithdraw() {
        // Testing withdrawal functionality
        bankAccount.deposit(10); // First deposit $10
        bankAccount.withdraw(12); // Attempt to withdraw $12, which should fail
        assertEquals(10.0, bankAccount.getBalance(), 0.0); // Balance should remain $10 because withdrawal failed due to insufficient funds
    }

    @Test
    public void testWithdrawValidAmount() {
        // Testing withdrawal with valid amount
        bankAccount.deposit(20); // Deposit $20
        bankAccount.withdraw(10); // Withdraw $10
        assertEquals(10.0, bankAccount.getBalance(), 0.0); // Balance should be $10 after withdrawal
    }

    @Test
    public void testWithdrawNegative() {
        // Testing withdrawal with a negative amount (should not change the balance)
        bankAccount.withdraw(-10); // Attempt to withdraw a negative amount
        assertEquals(0.0, bankAccount.getBalance(), 0.0); // Balance should remain 0.0 after invalid withdrawal
    }
}
