package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    // Arrange – Setup
    @Before
    public void setUp() {
        account = new BankAccount(100); // initial balance
        System.out.println("Setup complete.");
    }

    // Teardown
    @After
    public void tearDown() {
        account = null;
        System.out.println("Teardown complete.");
    }

    // Act + Assert
    @Test
    public void testDeposit() {
        // Act
        account.deposit(50);

        // Assert
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }
}
