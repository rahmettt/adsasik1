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
        System.out.println("Account added successfully");

        while (true) {
            System.out.println("\n--- Bank System Menu ---");
            System.out.println("1. Submit Account Request (User)");
            System.out.println("12. Process Request (Admin -> Move to List)");
            System.out.println("13. Display Pending Requests");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search account by username");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Undo");
            System.out.println("7. Peek");
            System.out.println("8. Add bill to queue");
            System.out.println("9. Complete next bill");

            System.out.println("10. Display queue");
            System.out.println("14. SHOW PHYSICAL ARRAY (Task 6)");

            System.out.println("99. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username for new account: ");
                    String nameReq = scanner.nextLine();
                    accountRequests.add(nameReq);
                    System.out.println("Request for '" + nameReq + "' added to queue.");
                    break;
                case 12:
                    if (!accountRequests.isEmpty()) {
                        String userToProcess = accountRequests.poll();
                        System.out.println("Processing request for: " + userToProcess);

                        System.out.print("Account Number for " + userToProcess + ": ");
                        String newAccNum = scanner.nextLine();
                        System.out.print("Balance: ");
                        double initialBal = scanner.nextDouble();

                        accounts.add(new BankAccount(newAccNum, userToProcess, initialBal));
                        System.out.println("Success! Account created and moved to main list.");
                    } else {
                        System.out.println("No pending requests to process.");
                    }
                    break;
                case 13:
                    System.out.println("Pending Requests (Queue): " + accountRequests);
                    break;
                case 2:
                    System.out.println("Accounts List:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter username to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (BankAccount acco : accounts) {
                        if (acco.username.equalsIgnoreCase(searchName)) {
                            System.out.println("Found: " + acco.accountNumber + " | " + acco.username + " | " + acco.balance);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Account not found.");
                    break;

                case 4:
                    System.out.println("Enter username fro deposit: ");
                    String depname = scanner.nextLine();
                    for (BankAccount acco : accounts){
                        if (acco.username.equalsIgnoreCase(depname)){
                            System.out.println("Enter deposit balance: ");
                            double depbal = scanner.nextDouble();
                            acco.deposit(depbal);
                            transactionHistory.push("Deposit " + depbal + " to " + depname);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter username fro withdraw: ");
                    String wname = scanner.nextLine();
                    for (BankAccount acco : accounts){
                        if (acco.username.equalsIgnoreCase(wname)){
                            System.out.println("Enter withdraw balance: ");
                            double wbal = scanner.nextDouble();
                            acco.withdraw(wbal);
                            transactionHistory.push("Withdraw " + wbal + " from " + wname);
                            break;
                        }
                    }
                    break;

                case 6:
                    if (!transactionHistory.isEmpty()) {
                        String removed = transactionHistory.pop();
                        System.out.println("Undo -> " + removed + " removed from history");
                    } else {
                        System.out.println("History is empty!");
                    }
                    break;

                case 7:
                    if (!transactionHistory.isEmpty()) {
                        System.out.println("Last transaction: " + transactionHistory.peek());
                    } else {
                        System.out.println("No transactions yet.");
                    }
                    break;
                case 8:
                    System.out.print("Enter bill name (e.g., Electricity Bill): ");
                    String bill = scanner.nextLine();
                    billQueue.add(bill);
                    System.out.println("Added: " + bill);
                    break;

                case 9:
                    if (!billQueue.isEmpty()) {
                        String processed = billQueue.poll();
                        System.out.println("Processing: " + processed);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 10:
                    if (!billQueue.isEmpty()) {
                        System.out.println("Remaining bills: " + billQueue);
                    } else {
                        System.out.println("No pending bills.");
                    }
                    break;
                case 14:
                    BankAccount[] physicalArray = new BankAccount[3];
                    physicalArray[0] = new BankAccount("A1", "Predefined1", 100);
                    physicalArray[1] = new BankAccount("A2", "Predefined2", 200);
                    physicalArray[2] = new BankAccount("A3", "Predefined3", 300);
                    System.out.println("--- Physical Structure (Array[3]) ---");
                    System.out.println("1. Print accounts");
                    System.out.println("2. Exit");
                    int a= scanner.nextInt();
                    if (a==1){
                        for (BankAccount acc : physicalArray) {
                            System.out.println(acc);
                        }
                    }
                    break;


                case 99:
                    System.out.println("Exiting...");
                    return;

            }
        }
    }
}