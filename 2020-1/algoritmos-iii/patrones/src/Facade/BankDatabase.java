package Facade;

public class BankDatabase {

    private double balance;

    public BankDatabase() {

        balance = Math.random() * 10000;
    }

    public double getAccountBalance() {

        return balance;
    }

    public void updateBalanceAfterCashWithdraw(int amountWithdrawn){

        System.out.println("Your balance was $" + balance + ".");
        balance -= amountWithdrawn;
        System.out.println("Your new balance is $" + balance + ".");
    }
}
