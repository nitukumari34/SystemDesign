package org.example.ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private int accNo;
    private int pin;
    private double balance;

    public Account(int accNo, int pin, double balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
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
    private String bankName;
    private List<Account> accountList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ATM(String bankName) {
        this.bankName = bankName;
    }

    void addAccount(Account account) {
        accountList.add(account);
    }

    Account authenticateUser(int accNo, int pin) {

        for (int i = 0; i < accountList.size(); i++) {

            Account account = accountList.get(i);

            if (account.getAccNo() == accNo &&
                    account.getPin() == pin) {

                return account;
            }
        }

        return null;
    }

    void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdrawal");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
    }

    void performOperation() {

        int choice;
        int accNo;
        int pin;

        Account currAccount = null;

        // Authentication
        do {
            System.out.println("Enter your account number:");
            accNo = sc.nextInt();

            System.out.println("Enter your PIN:");
            pin = sc.nextInt();

            currAccount = authenticateUser(accNo, pin);

            if (currAccount == null) {
                System.out.println("Invalid account number or PIN");
            }

        } while (currAccount == null);


        // ATM Operations
        do {

            displayMenu();

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = sc.nextDouble();

                    currAccount.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = sc.nextDouble();

                    currAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println(
                            "Current Balance: " +
                                    currAccount.getBalance()
                    );
                    break;

                case 4:
                    System.out.println(
                            "Thank you for using " +
                                    bankName + " ATM"
                    );
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 4);
    }
}

public class Main {

    public static void main(String[] args) {

        ATM atm = new ATM("SBI");

        Account account1 = new Account(101, 1234, 50000);
        Account account2 = new Account(102, 5678, 25000);

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