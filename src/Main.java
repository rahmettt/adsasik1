import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("New balance: " + this.balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("New balance: " + this.balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public String toString() {
        return username + " - Balance: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        Stack<String> transactionHistory = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<String> accountRequests = new LinkedList<>();

        accounts.add(new BankAccount("001", "Ali", 150000));
        accounts.add(new BankAccount("002", "Sara", 220000));

        while (true) {
            System.out.println("\n--- Mini Banking System ---");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Choose option: ");

            int mainMenuChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainMenuChoice == 4) {
                System.out.println("Exiting...");
                break;
            }

            switch (mainMenuChoice) {
                case 1: // --- Bank Menu ---
                    System.out.println("\n--- Bank Menu ---");
                    System.out.println("1. Submit account opening request");
                    System.out.println("2. Deposit money");
                    System.out.println("3. Withdraw money");
                    System.out.println("4. Back");
                    int bankChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (bankChoice) {
                        case 1:
                            System.out.print("Enter username for new account: ");
                            String nameReq = scanner.nextLine();
                            accountRequests.add(nameReq);
                            System.out.println("Request for '" + nameReq + "' added to queue.");
                            break;
                        case 2:
                            System.out.println("Enter username for deposit: ");
                            String depname = scanner.nextLine();
                            for (BankAccount acco : accounts) {
                                if (acco.username.equalsIgnoreCase(depname)) {
                                    System.out.println("Enter deposit balance: ");
                                    double depbal = scanner.nextDouble();
                                    acco.deposit(depbal);
                                    transactionHistory.push("Deposit " + depbal + " to " + depname);
                                    break;
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Enter username for withdraw: ");
                            String wname = scanner.nextLine();
                            for (BankAccount acco : accounts) {
                                if (acco.username.equalsIgnoreCase(wname)) {
                                    System.out.println("Enter withdraw balance: ");
                                    double wbal = scanner.nextDouble();
                                    acco.withdraw(wbal);
                                    transactionHistory.push("Withdraw " + wbal + " from " + wname);
                                    break;
                                }
                            }
                            break;
                    }
                    break;

                case 2: // --- ATM Menu ---
                    System.out.println("\n--- ATM Menu ---");
                    System.out.println("1. Balance enquiry");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Back");
                    int atmChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (atmChoice == 3) break;

                    System.out.print("Enter username: ");
                    String atmUser = scanner.nextLine();
                    for (BankAccount acco : accounts) {
                        if (acco.username.equalsIgnoreCase(atmUser)) {
                            if (atmChoice == 1) {
                                System.out.println("Balance: " + acco.balance);
                            } else if (atmChoice == 2) {
                                System.out.print("Enter withdraw amount: ");
                                double wbal = scanner.nextDouble();
                                acco.withdraw(wbal);
                                transactionHistory.push("ATM Withdraw " + wbal + " from " + atmUser);
                            }
                            break;
                        }
                    }
                    break;

                case 3: // --- Admin Area ---
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. View and process account queue");
                    System.out.println("2. View and process bill payment queue");
                    System.out.println("3. Show physical array (Task 6)");
                    System.out.println("4. View Transaction History (Stack)");
                    System.out.println("5. Back");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (adminChoice) {
                        case 1:
                            if (!accountRequests.isEmpty()) {
                                String userToProcess = accountRequests.poll();
                                System.out.println("Processing: " + userToProcess);
                                System.out.print("Assign Acc Number: ");
                                String newAccNum = scanner.nextLine();
                                System.out.print("Initial Balance: ");
                                double b = scanner.nextDouble();
                                accounts.add(new BankAccount(newAccNum, userToProcess, b));
                                System.out.println("Account created.");
                            } else {
                                System.out.println("Queue is empty.");
                            }
                            break;
                        case 2:
                            if (!billQueue.isEmpty()) {
                                System.out.println("Processing bill: " + billQueue.poll());
                            } else {
                                System.out.println("No bills to process.");
                            }
                            break;
                        case 3:
                            BankAccount[] physicalArray = new BankAccount[3];
                            physicalArray[0] = new BankAccount("A1", "Predefined1", 100);
                            physicalArray[1] = new BankAccount("A2", "Predefined2", 200);
                            physicalArray[2] = new BankAccount("A3", "Predefined3", 300);
                            for (BankAccount acc : physicalArray) System.out.println(acc);
                            break;
                        case 4:
                            if (!transactionHistory.isEmpty()) {
                                System.out.println("Last action (Peek): " + transactionHistory.peek());
                                System.out.println("Full history (Stack): " + transactionHistory);
                            } else {
                                System.out.println("History empty.");
                            }
                            break;
                    }
                    break;
            }
        }
    }
}