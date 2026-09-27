package org.example.ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {

    private final int accNo;
    private final int pin;
    private double balance;

    public Account(int accNo, int pin, double balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    public boolean authenticate(int pin) {
        return this.pin == pin;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance += amount;

        System.out.println("Amount deposited successfully");
        System.out.println("Current Balance: " + balance);
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return false;
        }

        balance -= amount;

        System.out.println("Amount withdrawn successfully");
        System.out.println("Current Balance: " + balance);

        return true;
    }
}


class ATM {

    private final String bankName;
    private final List<Account> accountList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public ATM(String bankName) {
        this.bankName = bankName;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    Account authenticateUser(int accNo, int pin) {

        for (Account account : accountList) {

            if (account.getAccNo() == accNo &&
                    account.authenticate(pin)) {

                return account;
            }
        }

        return null;
    }

    void displayMenu() {

        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdrawal");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    void performOperation() {

        Account currAccount = authenticate();

        if (currAccount == null) {
            return;
        }

        int choice;

        do {

            displayMenu();

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    withdraw(currAccount);
                    break;

                case 2:
                    deposit(currAccount);
                    break;

                case 3:
                    checkBalance(currAccount);
                    break;

                case 4:
                    System.out.println(
                            "Thank you for using " +
                                    bankName + " ATM"
                    );
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

    private Account authenticate() {

        while (true) {

            System.out.println("Enter your account number:");
            int accNo = sc.nextInt();

            System.out.println("Enter your PIN:");
            int pin = sc.nextInt();

            Account account = authenticateUser(accNo, pin);

            if (account != null) {
                System.out.println("Authentication successful");
                return account;
            }

            System.out.println("Invalid account number or PIN");
        }
    }

    private void withdraw(Account account) {

        System.out.println("Enter withdrawal amount:");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    private void deposit(Account account) {

        System.out.println("Enter deposit amount:");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    private void checkBalance(Account account) {

        System.out.println(
                "Current Balance: " +
                        account.getBalance()
        );
    }
}


public class Main {

    public static void main(String[] args) {

        ATM atm = new ATM("SBI");

        Account account1 =
                new Account(101, 1234, 50000);

        Account account2 =
                new Account(102, 5678, 25000);

        atm.addAccount(account1);
        atm.addAccount(account2);

        atm.performOperation();
    }
}
//
//Main
//  ↓
//ATM created
//  ↓
//Accounts added
//  ↓
//performOperation()
//  ↓
//Authenticate user
//  ↓
//currAccount
//  ↓
//          ┌──────────────────────┐
//          │ ATM Menu             │
//        ├──────────────────────┤
//        │ 1. Withdraw          │ → Account.withdraw()
//│ 2. Deposit           │ → Account.deposit()
//│ 3. Balance           │ → Account.getBalance()
//│ 4. Exit              │