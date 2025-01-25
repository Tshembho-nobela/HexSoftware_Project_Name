/*
Implement classes for Bank account and customer.
Allow users to create a new account, deposit money,withdraw money, and check their balance.
include basic error handling.
*/


import java.util.*;

public class Bank {
    String name;
    String surname;
    double balance;
    long accountnumber;
    int pin;

    Vector<Bank> accounts = new Vector<>();
    Scanner scanner = new Scanner(System.in);

  
    public Bank(String name, String surname, double balance, long accountnumber, int pin) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accountnumber = accountnumber;
        this.pin = pin;
    }

  //display menu
    void Display() {
        System.out.println("1. Create account");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Balance");
        System.out.println("5. My information");
        System.out.println("6. Exit");
    }

    //  creating Account
    void CreateAccount() {
        Random random = new Random();
        long AccountNumber = 100000000000L + (long) (random.nextDouble() * 900000000000L);
        System.out.print("What is your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the amount of money to deposit: ");
        double balance = scanner.nextDouble();
        System.out.print("Set a 4-digit PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); 
        Bank newAccount = new Bank(name, surname, balance, AccountNumber, pin);
        accounts.add(newAccount);
        System.out.println("Account created, your account number is: " + AccountNumber);
    }

   // finding account within the bank system
    Bank findAccount() {
        System.out.print("Please enter your account number: ");
        long accountNumber = scanner.nextLong();
        for (Bank account : accounts) {
            if (account.accountnumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

 
   // checking balance function
    void Balance() {
        Bank account = findAccount();
        System.out.print("please enter our PIN:");
        int pin = scanner.nextInt();
        if (account != null && pin == account.pin) {
            System.out.println("Your current balance is: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    //method to withdraw money
    void Withdraw() {
        Bank account = findAccount();
        if (account != null) {
            System.out.print("Please enter your PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin == account.pin) {
                try {
                    System.out.print("Please enter the amount you want to withdraw: ");
                    double money = scanner.nextDouble();
                    if (account.balance >= money) {
                        account.balance -= money;
                        System.out.println("Money withdrawn: " + money + "\nCurrent balance is: " + account.balance);
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    scanner.nextLine(); 
                }
            } else {
                System.out.println("Incorrect PIN.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    

// function to get information 
    void AccountDetails() {
        scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Bank account : accounts) {
            if (account.name.equals(name)) {
                System.out.println("Your name: " + account.name);
                System.out.println("Your surname: " + account.surname);
                System.out.println("Your account number: " + account.accountnumber);
                System.out.println("Your balance: " + account.balance);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found.");
        }
    }
    //function to deposit money 
    void Deposit() {
        Bank account = findAccount();
        if (account != null ) {
            try {
                System.out.print("Please enter the amount you want to deposit: ");
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Deposit money > 0.");
                } else {
                    account.balance += amount;
                    System.out.println("Successful deposit.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric amount.");
                scanner.nextLine(); 
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    

}