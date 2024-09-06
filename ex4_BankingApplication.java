package exp4;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Balance Enquiry");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Account Creation
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter Initial Balance (minimum 500): ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    if (initialBalance >= 500) {
                        account = new BankAccount(accountNumber, accountHolderName, initialBalance);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Initial balance must be at least 500.");
                    }
                    break;

                case 2:
                    // Balance Enquiry
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 3:
                    // Deposit
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    // Withdraw
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
