/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threads;

/**
 *
 * @author USER
 */

public class Threads {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000000);

        Thread depositThread1 = new DepositThread(account, 200000);
        Thread depositThread2 = new DepositThread(account, 300000);
        Thread withdrawThread1 = new Thread(new WithdrawThread(account, 150000));
        Thread withdrawThread2 = new Thread(new WithdrawThread(account, 500000));

        depositThread1.setName("Deposit Instance 1");
        depositThread2.setName("Deposit Instance 2");
        withdrawThread1.setName("Withdraw Instance 1");
        withdrawThread2.setName("Withdraw Instance 2");

            depositThread1.start();
            depositThread2.start();
            withdrawThread1.start();
            withdrawThread2.start();

           try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
