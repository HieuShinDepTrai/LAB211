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
public class Main {

    public static void main(String[] args) {
        Startup s = new Startup(1000);
        Credit cr1 = new Credit(1500);
        System.out.println(cr1);
        Credit cr2 = new Credit(500); 
        Debit db1 = new Debit(500);  
        Debit db2 = new Debit(2000); 

        MinMaxAccount minMaxAccount = new MinMaxAccount(s);
        minMaxAccount.credit(cr1); 
        minMaxAccount.debit(db1); 
        minMaxAccount.credit(cr2); 
        minMaxAccount.debit(db2); 

        System.out.println("Minimum Balance in the Bank Account: $" + minMaxAccount.getMin());
        System.out.println("Maximum Balnace in the Bank Account: $" + minMaxAccount.getMax());
        System.out.println("Currend Balance in the Bank Account: $" + minMaxAccount.getBalance());

    }
}
