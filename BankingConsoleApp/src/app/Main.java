package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to Console Bank");

        while (running){
            System.out.println("""
                1. Open Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Account Statement
                6. List Account
                7. Search Accounts by Customer Name
                0. Exit
                """);
            System.out.print("CHOOSE: ");
            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1" -> openAccount(scanner);
//                case "2" -> deposit(scanner);
//                case "3" -> withdraw(scanner);
//                case "4" -> transfer(scanner);
//                case "5" -> statement(scanner);
//                case "6" -> listAccount(scanner);
//                case "7" -> searchAccount(scanner);
                case "0" -> running = false;
            }
        }

    }


    private static void openAccount(Scanner scanner) {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Customer Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Account Type (SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        
        System.out.print("Initial Deposit (optional, blank for 0): ");
        Double initialDeposit = scanner.nextDouble();




    }
}
