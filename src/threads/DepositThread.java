/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author USER
 */
public class DepositThread extends Thread {
    private BankAccount account;
    private double amount;

    /*constructor*/
    public DepositThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    /*run method*/
    @Override
    public void run() {
        account.deposit(amount);
    }
}
