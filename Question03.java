class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Bank {
    private BankAccount[] bankAccounts;
    private int count;

    public Bank(int size) {
        bankAccounts = new BankAccount[size];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < bankAccounts.length) {
            bankAccounts[count++] = account;
        } else {
            System.out.println("Bank is full, cannot add more accounts.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        for (int i = 0; i < count; i++) {
            if (bankAccounts[i].getAccountNumber() == accountNumber) {
                if (bankAccounts[i].getBalance() >= amount) {
                    bankAccounts[i].setBalance(bankAccounts[i].getBalance() - amount);
                    System.out.println("Withdrawal successful. New balance: " + bankAccounts[i].getBalance());
                } else {
                    throw new IllegalArgumentException("Insufficient funds.");
                }
                return;
            }
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public void displayAccounts() {
        for (int i = 0; i < count; i++) {
            System.out.println("Account Number: " + bankAccounts[i].getAccountNumber() +
                    ", Holder: " + bankAccounts[i].getAccountHolder() +
                    ", Balance: " + bankAccounts[i].getBalance());
        }
    }
}

public class Question03 {
    public static void main(String[] args) {
        Bank bank = new Bank(5); 

        BankAccount account1 = new BankAccount(1001, "Alice", 5000.0);
        BankAccount account2 = new BankAccount(1002, "Bob", 3000.0);

        bank.addAccount(account1);
        bank.addAccount(account2);

        try {
            bank.withdraw(1001, 6000); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bank.withdraw(1002, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        bank.displayAccounts(); 
    }
}