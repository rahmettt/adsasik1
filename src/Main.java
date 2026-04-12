import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }
}

class MyStack<T> {
    private Node<T> top;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

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
        MyLinkedList<BankAccount> accounts = new MyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        MyStack<String> transactionHistory = new MyStack<>();
        MyQueue<String> billQueue = new MyQueue<>();
        MyQueue<String> accountRequests = new MyQueue<>();

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

                case 1:
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
                            accountRequests.enqueue(nameReq);
                            System.out.println("Request for '" + nameReq + "' added to queue.");
                            break;

                        case 2:
                            System.out.println("Enter username for deposit: ");
                            String depname = scanner.nextLine();
                            Node<BankAccount> curr2 = accounts.getHead();
                            while (curr2 != null) {
                                if (curr2.data.username.equalsIgnoreCase(depname)) {
                                    System.out.println("Enter deposit balance: ");
                                    double depbal = scanner.nextDouble();
                                    curr2.data.deposit(depbal);
                                    transactionHistory.push("Deposit " + depbal + " to " + depname);
                                    break;
                                }
                                curr2 = curr2.next;
                            }
                            break;

                        case 3:
                            System.out.println("Enter username for withdraw: ");
                            String wname = scanner.nextLine();
                            Node<BankAccount> curr3 = accounts.getHead();
                            while (curr3 != null) {
                                if (curr3.data.username.equalsIgnoreCase(wname)) {
                                    System.out.println("Enter withdraw balance: ");
                                    double wbal = scanner.nextDouble();
                                    curr3.data.withdraw(wbal);
                                    transactionHistory.push("Withdraw " + wbal + " from " + wname);
                                    break;
                                }
                                curr3 = curr3.next;
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n--- ATM Menu ---");
                    System.out.println("1. Balance enquiry");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Back");
                    int atmChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (atmChoice == 3) break;

                    System.out.print("Enter username: ");
                    String atmUser = scanner.nextLine();
                    Node<BankAccount> atmCurr = accounts.getHead();
                    while (atmCurr != null) {
                        if (atmCurr.data.username.equalsIgnoreCase(atmUser)) {
                            if (atmChoice == 1) {
                                System.out.println("Balance: " + atmCurr.data.balance);
                            } else if (atmChoice == 2) {
                                System.out.print("Enter withdraw amount: ");
                                double wbal = scanner.nextDouble();
                                atmCurr.data.withdraw(wbal);
                                transactionHistory.push("ATM Withdraw " + wbal + " from " + atmUser);
                            }
                            break;
                        }
                        atmCurr = atmCurr.next;
                    }
                    break;

                case 3:
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. View and process account queue");
                    System.out.println("2. View and process bill payment queue");
                    System.out.println("3. Show physical array");
                    System.out.println("4. View Transaction History (Stack)");
                    System.out.println("5. Back");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (adminChoice) {
                        case 1:
                            if (!accountRequests.isEmpty()) {
                                String userToProcess = accountRequests.dequeue();
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
                                System.out.println("Processing bill: " + billQueue.dequeue());
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
