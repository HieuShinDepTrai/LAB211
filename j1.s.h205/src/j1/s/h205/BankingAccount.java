/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h205;

/**
 *
 * @author lanh0
 */
public class BankingAccount {

    private double balance;

    public BankingAccount() {
    }

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    public void debit(Debit d) {
        if (balance - d.getDebitAmount() >= 0) {
            balance = balance - d.getDebitAmount();
        } else System.out.println("The balance is not enough to make this transaction");
    }

    public void credit(Credit c) {
        balance = balance + c.getCreditAmount();
    }

    public double getBalance() {
        return balance;
    }
}
