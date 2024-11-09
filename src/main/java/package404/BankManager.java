package package404;

import java.util.HashMap;
import java.util.Scanner;

public class BankManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account added successfully.");
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nBank Manager Menu:");
            System.out.println("1. View Account Details");
            System.out.println("2. Modify Account Holder Name");
            System.out.println("3. create new Account");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    viewAccountDetails(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    modifyAccountHolderName(accountNumber);
                    break;
                case 3:
                    System.out.println("create new account");
                    System.out.println("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.println("Enter account holder name: ");
                    String name=scanner.nextLine();
                    createNewAccount(accountNumber,name);
                    break;
                case 4:
                    System.out.println("Exiting Bank Manager Menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createNewAccount(String accountNumber, String name) {
        BankAccount account = new BankAccount(accountNumber,name);
        accounts.put(accountNumber, account);
    }

    private void viewAccountDetails(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void modifyAccountHolderName(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter new account holder name: ");
            String newName = scanner.nextLine();
            account.setAccountHolderName(newName);
            System.out.println("Account holder name updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}
