package Bank_application;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApplication {
    
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static int accountCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Application Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        String accountNumber = "AC" + accountCounter++;
        System.out.println("Account created with account number: " + accountNumber);

        System.out.print("Enter initial deposit amount: $");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter deposit amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            BankAccount account = accounts.get(accountNumber);
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            BankAccount account = accounts.get(accountNumber);
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }
}
