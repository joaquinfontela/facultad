package Facade;

import java.util.Scanner;

public class ATM {

    public void withdrawCash() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your card id: ");
        int cardId = scanner.nextInt();

        if (!(new CardReader().cardIsValid(cardId))){
            System.out.println("Card id: " + cardId + " not valid.");
            return;
        }

        BankDatabase bankDatabase = new BankDatabase();
        System.out.println("Type the amount to withdraw ($0-10000): ");
        int amountTowithdraw = scanner.nextInt();

        if (amountTowithdraw > bankDatabase.getAccountBalance()){
            System.out.println("Error: you cannot withdraw $" + amountTowithdraw + " because your balance is $" + bankDatabase.getAccountBalance());
            return;
        }

        new CashDeliverer().deliverCash(amountTowithdraw);
        bankDatabase.updateBalanceAfterCashWithdraw(amountTowithdraw);
    }
}
