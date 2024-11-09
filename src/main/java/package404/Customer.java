package package404;

import java.util.Scanner;

public class Customer {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public Customer(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting Customer Menu.");

                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}