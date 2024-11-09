package package404;

import java.sql.*;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        // JDBC configuration details
        String url = "jdbc:mysql://localhost:3306/BankingApp"; // Replace with your DB name if different
        String username = "root";
        String password = "MySQLdora015$";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Scanner scanner = new Scanner(System.in);

            // Set up an example bank account and customer for testing
            BankAccount account = new BankAccount("12345", "Dora");
            Customer customer = new Customer(account);

            BankManager bankManager = new BankManager();
            bankManager.addAccount(account); // Add to in-memory structure

            System.out.println("Connected to database successfully!");

            while (true) {
                System.out.println("\nBanking Application Login:");
                System.out.println("1. Customer");
                System.out.println("2. Bank Manager");
                System.out.println("3. Exit");
                System.out.print("Choose a role to log in: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        customer.showMenu();
                        break;
                    case 2:
                        bankManager.showMenu();
                        break;
                    case 3:
                        System.out.println("Thank you for using our banking application!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
